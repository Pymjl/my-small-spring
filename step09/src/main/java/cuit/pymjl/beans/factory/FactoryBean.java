package cuit.pymjl.beans.factory;

/**
 * Interface to be implemented by objects used within a {@link BeanFactory}
 * which are themselves factories. If a bean implements this interface,
 * it is used as a factory for an object to expose, not directly as a bean
 * instance that will be exposed itself.
 * <p>
 * 由 {@link BeanFactory} 中使用的对象实现的接口，这些对象本身就是工厂。
 * 如果一个 bean 实现了这个接口，它被用作一个对象的工厂来暴露，而不是直接作为一个将自己暴露的 bean 实例。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 23:52
 **/
public interface FactoryBean<T> {
    /**
     * 获取工厂bean的实例
     *
     * @return {@code T}
     * @throws Exception 异常
     */
    T getObject() throws Exception;

    /**
     * 得到工厂bean的类型
     *
     * @return {@code Class<?>}
     */
    Class<?> getObjectType();

    /**
     * 判断工厂bean是否单例
     *
     * @return boolean
     */
    boolean isSingleton();
}
