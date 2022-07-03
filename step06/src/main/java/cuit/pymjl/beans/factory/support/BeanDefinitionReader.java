package cuit.pymjl.beans.factory.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.core.io.Resource;
import cuit.pymjl.core.io.ResourceLoader;

/**
 * 这是一个 Simple interface for bean definition readers. 其实里面无非定义了几个方
 * 法，包括： getRegistry() 、 getResourceLoader()，以及三个加载 Bean 定义的方法。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:50
 **/
public interface BeanDefinitionReader {
    /**
     * 用于提供给后面三个方法的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
     *
     * @return {@code BeanDefinitionRegistry}
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获得资源加载器
     * 用于提供给后面三个方法的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
     *
     * @return {@code ResourceLoader}
     */
    ResourceLoader getResourceLoader();

    /**
     * 通过配制文件加载BeanDefinition，方便后续的注册。
     *
     * @param resource 资源文件
     * @throws BeansException 异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 通过配制文件加载BeanDefinition，方便后续的注册。
     * 参数为资源的数组，可以加载多个配制文件。
     *
     * @param resources 资源文件数组
     * @throws BeansException 异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 通过配制文件的路径加载BeanDefinition，方便后续的注册。
     *
     * @param location 资源文件的位置
     * @throws BeansException 异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 通过配制文件的路径加载BeanDefinition，方便后续的注册
     *
     * @param locations 资源文件的位置数组
     * @throws BeansException 异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
