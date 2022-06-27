package cuit.epoch.pymjl.beans.factory.support;

import cuit.epoch.pymjl.beans.BeansException;
import cuit.epoch.pymjl.beans.factory.BeanFactory;
import cuit.epoch.pymjl.beans.factory.config.BeanDefinition;

/**
 * 这是模板类，参照模板模式，将对应的逻辑先创建好一个模板，再由子类实现具体细节
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:23
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 这是模板方法，定义执行逻辑
     *
     * @param name 对象名称
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //先调用单例工厂，获取对象
        Object bean = getSingleton(name);
        //如果对象不为空，直接获取
        if (null != bean) {
            return bean;
        }
        //如果为空，则创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 创建bean，这是抽象方法，具体实现由子类决定
     *
     * @param name           名字
     * @param beanDefinition bean定义
     * @return {@code Object}
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    /**
     * 获取BeanDefinition,这是抽象方法，具体实现由子类决定
     *
     * @param name 名字
     * @return {@code BeanDefinition}
     */
    protected abstract BeanDefinition getBeanDefinition(String name);
}
