package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.BeansException;

/**
 * 允许自定义修改新 bean 实例的工厂钩子，例如检查标记接口或用代理包装它们
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:03
 **/
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     实例化的对象
     * @param beanName 对象名字
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     实例化的对象
     * @param beanName 对象名字
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
