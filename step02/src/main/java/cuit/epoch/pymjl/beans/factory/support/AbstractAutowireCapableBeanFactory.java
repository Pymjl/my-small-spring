package cuit.epoch.pymjl.beans.factory.support;

import cuit.epoch.pymjl.beans.BeansException;
import cuit.epoch.pymjl.beans.factory.config.BeanDefinition;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:36
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }
}
