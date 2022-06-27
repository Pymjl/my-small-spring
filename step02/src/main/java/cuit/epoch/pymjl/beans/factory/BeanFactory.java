package cuit.epoch.pymjl.beans.factory;

import cuit.epoch.pymjl.beans.BeansException;

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
}
