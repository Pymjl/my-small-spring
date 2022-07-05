package cuit.pymjl.beans.factory.config;

/**
 * 这个接口用于提供管理单例对象的接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:14
 **/
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     *
     * @param name 对象名
     * @return {@code Object}
     */
    Object getSingleton(String name);

    /**
     * 登记单
     *
     * @param beanName        bean名字
     * @param singletonObject 单例对象
     */
    void registerSingleton(String beanName, Object singletonObject);


}
