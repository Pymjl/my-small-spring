package cuit.pymjl.beans.factory;


import cuit.pymjl.beans.BeansException;

/**
 * 对外暴露获取实例对象的接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:22
 **/
public interface BeanFactory {
    /**
     * 获取实例化对象
     *
     * @param name 名字
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 通过类型获取实例化对象，有参构造
     *
     * @param name 对象名
     * @param args 参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 通过类型获取实例化对象，无参构造
     *
     * @param name         名字
     * @param requiredType 所需类型
     * @return {@code T}
     * @throws BeansException 异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
