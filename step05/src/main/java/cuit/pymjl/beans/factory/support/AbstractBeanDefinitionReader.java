package cuit.pymjl.beans.factory.support;

import cuit.pymjl.core.io.DefaultResourceLoader;
import cuit.pymjl.core.io.ResourceLoader;

/**
 * 抽象类把 BeanDefinitionReader 接口的前两个方法全部实现完了，并提供了构造函数，让外部的调用使用方，把 Bean 定义注入类，传递进来。
 * 这样在接口 BeanDefinitionReader 的具体实现类中，就可以把解析后的 XML 文件中的 Bean 信息，注册到 Spring 容器去了。
 * 以前我们是通过单元测试使用，调用 BeanDefinitionRegistry 完成 Bean 的注册，现在可以放到 XMl 中操作了
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:56
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 向容器中注册 BeanDefinition的注册器
     */
    private final BeanDefinitionRegistry registry;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取 BeanDefinitionRegistry，这个接口提供向容器中注册 BeanDefinition 的方法。
     *
     * @return {@code BeanDefinitionRegistry}
     */
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    /**
     * 获得资源加载器
     *
     * @return {@code ResourceLoader}
     */
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
