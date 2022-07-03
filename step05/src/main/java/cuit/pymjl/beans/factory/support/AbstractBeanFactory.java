package cuit.pymjl.beans.factory.support;


import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.BeanFactory;
import cuit.pymjl.beans.factory.config.BeanDefinition;

/**
 * 这是模板类，参照模板模式，将对应的逻辑先创建好一个模板，再由子类实现具体细节
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:23
 **/
@SuppressWarnings("unchecked")
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 根据名字获取对象的实例，通过无参构造方法获取
     *
     * @param name 名字
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    /**
     * 根据名字获取对象的实例，通过有参构造方法获取
     *
     * @param name 对象名
     * @param args 有参构造方法的参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    /**
     * 根据类型获取对象的实例，通过无参构造方法获取
     *
     * @param name         名字
     * @param requiredType 对象的类型
     * @return {@code T}
     * @throws BeansException 异常
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }


    /**
     * 实例化对象的模板方法
     *
     * @param name 名字
     * @param args 有参构造方法的参数
     * @return {@code T}
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 1.先从单例容器中获取对象
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        // 2.如果单例容器中没有，则从BeanDefinition的容器中获取BeanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 3.根据BeanDefinition创建对象
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
