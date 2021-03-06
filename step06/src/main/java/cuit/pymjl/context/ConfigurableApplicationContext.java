package cuit.pymjl.context;

import cuit.pymjl.beans.BeansException;

/**
 * ConfigurableApplicationContext 继承自 ApplicationContext ，并提供了 refresh 这
 * 个核心方法。 如果你有看过一些 Spring 源码，那么一定会看到这个方法。 接下
 * 来也是需要在上下文的实现中完成刷新容器的操作过程。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:12
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException 异常
     */
    void refresh() throws BeansException;
}
