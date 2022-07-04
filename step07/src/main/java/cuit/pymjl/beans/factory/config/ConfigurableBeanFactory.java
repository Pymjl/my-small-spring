package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.factory.BeanFactory;
import cuit.pymjl.beans.factory.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:12
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 向AbstractBeanFactory注册BeanPostProcessor,以便在bean初始化前后执行某些操作
     *
     * @param beanPostProcessor 前、后置处理器
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
