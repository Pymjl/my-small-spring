package cuit.pymjl.beans.factory.support;


import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.BeanPostProcessor;
import cuit.pymjl.beans.factory.config.ConfigurableBeanFactory;
import cuit.pymjl.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是模板类，参照模板模式，将对应的逻辑先创建好一个模板，再由子类实现具体细节
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:23
 **/
@SuppressWarnings("unchecked")
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /**
     * 如有必要，使用 ClassLoader 解析 bean 类名
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * 在 createBean 中应用的 BeanPostProcessors容器
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * 根据名字获取对象的实例，通过无参构造方法获取
     *
     * @param name 名字
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    /**
     * 根据名字获取对象的实例，通过有参构造方法获取
     *
     * @param name 对象名
     * @param args 有参构造方法的参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    /**
     * 根据类型获取对象的实例，通过无参构造方法获取
     *
     * @param name         名字
     * @param requiredType 对象的类型
     * @return {@code T}
     * @throws BeansException 异常
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }


    /**
     * 实例化对象的模板方法
     *
     * @param name 名字
     * @param args 有参构造方法的参数
     * @return {@code T}
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 1.先从单例容器中获取对象
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        // 2.如果单例容器中没有，则从BeanDefinition的容器中获取BeanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 3.根据BeanDefinition创建对象
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
