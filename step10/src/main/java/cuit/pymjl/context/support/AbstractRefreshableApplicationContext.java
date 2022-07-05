package cuit.pymjl.context.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.ConfigurableListableBeanFactory;
import cuit.pymjl.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:23
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    /**
     * bean工厂
     */
    private DefaultListableBeanFactory beanFactory;

    /**
     * 获取DefaultListableBeanFactory
     *
     * @throws BeansException 异常
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 对spring.xml 配置文件中 Bean 对象的定义和注册，同时也包括实现了接口
     * BeanFactoryPostProcessor 、 BeanPostProcessor 的配置 Bean 信息。
     * 抽象方法，由子类实现。
     *
     * @param beanFactory bean工厂
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
