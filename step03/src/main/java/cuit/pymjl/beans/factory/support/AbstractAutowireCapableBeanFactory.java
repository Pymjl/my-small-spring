package cuit.pymjl.beans.factory.support;


import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:36
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 实例化对象的策略，jdk的默认实现是DefaultInstantiationStrategy，这是cglib的实现
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建bean实例
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     * @param args           有参构造函数的参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 1.真正的创建bean实例
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //将对象放入单例对象缓存中
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建bean实例
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名字
     * @param args           arg游戏
     * @return {@code Object}
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        // 1.获取bean的字节码
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 2.获取bean的所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                // 3.如果构造函数的参数个数与传入的参数个数一致，则对改构造函数进行赋值
                constructorToUse = ctor;
                break;
            }
        }
        // 4.根据对应的实例化策略，返回实例化的对象
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
