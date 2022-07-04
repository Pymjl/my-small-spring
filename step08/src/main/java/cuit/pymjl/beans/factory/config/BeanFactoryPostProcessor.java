package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.ConfigurableListableBeanFactory;

/**
 * <p>
 * 允许自定义修改应用程序上下文的 bean 定义，调整上下文底层 bean 工厂的 bean 属性值
 * </p>
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:01
 **/
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory 对象工厂
     * @throws BeansException 异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
