package cuit.pymjl.beans.factory;

/**
 * 由想要在销毁时释放资源的 bean 实现的接口。
 * 如果 BeanFactory 释放缓存的单例，则应该调用 destroy 方法。应用程序上下文应该在关闭时处理其所有单例
 * 这个接口主要是提供给一些第三方组件时对象销毁时释放资源。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 19:41
 **/
public interface DisposableBean {
    /**
     * 销毁操作
     *
     * @throws Exception 异常
     */
    void destroy() throws Exception;
}
