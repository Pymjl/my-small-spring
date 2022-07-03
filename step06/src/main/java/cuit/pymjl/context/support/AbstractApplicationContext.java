package cuit.pymjl.context.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.ConfigurableListableBeanFactory;
import cuit.pymjl.beans.factory.config.BeanFactoryPostProcessor;
import cuit.pymjl.beans.factory.config.BeanPostProcessor;
import cuit.pymjl.context.ApplicationContext;
import cuit.pymjl.context.ConfigurableApplicationContext;
import cuit.pymjl.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * Abstract implementation of the {@link ApplicationContext}
 * interface. Doesn't mandate the type of storage used for configuration; simply
 * implements common context functionality. Uses the Template Method design pattern,
 * requiring concrete subclasses to implement abstract methods.
 * <p>
 * {@link ApplicationContext} 接口的抽象实现。不强制要求用于配置的存储类型；
 * 简单地实现通用的上下文功能。使用模板方法设计模式，需要具体的子类来实现抽象方法。
 * <p>
 * 继承DefaultResourceLoader，是为了处理spring.xml文件的资源加载。
 * <p>
 * 实现了ConfigurableApplicationContext接口，在refresh()方法中定义实现过程
 * <p>
 * 另外把定义出来的抽象方法， refreshBeanFactory() 、 getBeanFactory() 由后面的继
 * 承此抽象类的其他抽象类实现。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:15
 **/
public abstract class AbstractApplicationContext extends DefaultResourceLoader
        implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 刷新bean工厂
     *
     * @throws BeansException 异常
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }
}
