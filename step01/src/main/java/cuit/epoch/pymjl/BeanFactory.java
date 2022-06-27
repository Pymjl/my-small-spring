package cuit.epoch.pymjl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanFactory其实就是Spring IOC的底层，spring通过这个工厂来创建对象
 * 这个对象里面拥有容器，容器其实就是一个map，我们将创建好的对象放在容器中
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 19:25
 **/
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 通过工厂类获取对象
     *
     * @param name 名字
     * @return {@code Object}
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册bean定义
     *
     * @param name           名字
     * @param beanDefinition bean定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.computeIfAbsent(name, k -> beanDefinition);
    }
}
