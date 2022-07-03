package cuit.pymjl.beans.factory.support;


import cuit.pymjl.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类是SingletonBeanRegistry的实现类，负责对单例对象的添加和获取
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:24
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonMap = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonMap.get(name);
    }

    protected void addSingleton(String name, Object bean) {
        singletonMap.put(name, bean);
    }
}
