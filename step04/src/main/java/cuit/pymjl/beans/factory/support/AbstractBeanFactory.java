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
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 仅通过对象名获取实例化对象，无参构造
     *
     * @param name 对象名
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    /**
     * 通过对象名和参数获取实例化对象，有参构造
     *
     * @param name 对象名
     * @param args 构造函数入参
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        //1.获取单例对象
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        //如果没有单例对象，则创建一个新的对象
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
