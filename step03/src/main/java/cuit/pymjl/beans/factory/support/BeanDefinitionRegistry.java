package cuit.pymjl.beans.factory.support;

import cuit.pymjl.beans.factory.config.BeanDefinition;

/**
 * 这个接口是管理BeanDefinition的接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:20
 **/
public interface BeanDefinitionRegistry {
    /**
     * 注册beanDefinition,即向容器中加入对应的k，v值
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
