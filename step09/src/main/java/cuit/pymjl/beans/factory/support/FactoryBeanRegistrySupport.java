package cuit.pymjl.beans.factory.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FactoryBeanRegistrySupport 类主要处理的就是关于 FactoryBean 此类对象的注册
 * 操作，之所以放到这样一个单独的类里，就是希望做到不同领域模块下只负责各自
 * 需要完成的功能，避免因为扩展导致类膨胀到难以维护。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 23:54
 **/
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    /**
     * 从Factory中获得对象
     *
     * @param factory  工厂
     * @param beanName bean名字
     * @return {@code Object}
     */
    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        // 1. 如果是单例的，就从缓存中获取对象
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            // 2. 如果缓存中没有，就从工厂中获取对象
            if (object == null) {
                // 3. 获取对象
                object = doGetObjectFromFactoryBean(factory, beanName);
                // 4. 将对象放入缓存中，实际上即便是null，也会放一个空的Object进去
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            // 5. 返回对象,如果对象为Object空对象，则返回null
            return (object != NULL_OBJECT ? object : null);
        } else {
            // 6. 如果是非单例的，就直接从工厂中获取对象
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            // 获取对象，由实现类完成
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
