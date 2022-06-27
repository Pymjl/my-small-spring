package cuit.epoch.pymjl.beans.factory.support;

import cuit.epoch.pymjl.beans.BeansException;
import cuit.epoch.pymjl.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 这是核心类，它负责管理BeanDefinition
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:38
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + name + "' is defined");
        }
        return beanDefinition;
    }
}
