package cuit.pymjl.beans.factory;

import cuit.pymjl.beans.BeansException;

/**
 * Interface to be implemented by beans that wish to be aware of their
 * owning {@link BeanFactory}.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:34
 **/
public interface BeanFactoryAware extends Aware {
    /**
     * 设置bean工厂
     *
     * @param beanFactory bean工厂
     * @throws BeansException 异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
