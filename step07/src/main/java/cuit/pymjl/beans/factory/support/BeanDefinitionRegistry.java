package cuit.pymjl.beans.factory.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanDefinition;

/**
 * 这个接口是管理BeanDefinition的接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:20
 **/
public interface BeanDefinitionRegistry {
    /**
     * 注册beanDefinition,即向容器中加入对应的k，v值
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
