package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.BeanFactory;

/**
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:11
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean 已经存在的 Bean 对象
     * @param beanName     Bean 名称
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean 已经存在的 Bean 对象
     * @param beanName     Bean 名称
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
