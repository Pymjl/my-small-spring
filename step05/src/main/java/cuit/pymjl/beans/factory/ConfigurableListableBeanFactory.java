package cuit.pymjl.beans.factory;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.AutowireCapableBeanFactory;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:14
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory,
        ConfigurableBeanFactory {

    /**
     * 得到bean定义
     *
     * @param beanName bean名字
     * @return {@code BeanDefinition}
     * @throws BeansException 豆子例外
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
