package cuit.pymjl.context.event;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.BeanFactory;
import cuit.pymjl.beans.factory.BeanFactoryAware;
import cuit.pymjl.context.ApplicationEvent;
import cuit.pymjl.context.ApplicationListener;
import cuit.pymjl.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Abstract implementation of the {@link ApplicationEventMulticaster} interface,
 * providing the basic listener registration facility.
 * <p>
 * {@link ApplicationEventMulticaster} 接口的抽象实现，提供基本的监听器注册工具。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 21:47
 **/
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    /**
     * 存储所有的监听器
     */
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    /**
     * bean工厂
     */
    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public final void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * Return a Collection of ApplicationListeners matching the given
     * event type. Non-matching listeners get excluded early.
     * 获取指定ApplicationEvent类型的所有监听器,其他的监听器会被排除掉。
     *
     * @param event the event to be propagated. Allows for excluding
     *              non-matching listeners early, based on cached matching information.
     * @return a Collection of ApplicationListeners
     * @see cuit.pymjl.context.ApplicationListener
     */
    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        // 1.创建一个新的链表集合
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        // 2.遍历所有的监听器
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            // 3.判断监听器是否匹配传入的event类型
            if (supportsEvent(listener, event)) {
                // 4.如果匹配，则添加到链表中
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 判断监听器是否匹配传入的event类型
     *
     * @param applicationListener 监听器
     * @param event               事件
     * @return boolean 是否匹配
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        // 1.获取监听器字节码
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 2.按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 class
        // cglib代理类需要获取目标类的父类，普通实例化类不需要
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        // 3.获取实现对应ApplicationListener接口的类型（包括泛型信息）
        Type genericInterface = targetClass.getGenericInterfaces()[0];
        // 4.强转为ParameterizedType（参数化类型即泛型），获取其泛型的实际类型
        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是Object。
        // 如果A.isAssignableFrom(B)结果是true，证明B可以转换成为A,也就是A可以由B转换而来。
        return eventClassName.isAssignableFrom(event.getClass());
    }

}
