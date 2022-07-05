package cuit.pymjl.beans.factory.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/1 21:23
 **/
public interface InstantiationStrategy {
    /**
     * 实例化对象
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名字
     * @param ctor           构造函数
     * @param args           参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
