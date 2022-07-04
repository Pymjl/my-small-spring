package cuit.pymjl.context;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.Aware;

/**
 * Interface to be implemented by any object that wishes to be notified
 * of the {@link ApplicationContext} that it runs in.
 * <p>
 * 由希望被通知其运行的 {@link ApplicationContext} 的任何对象实现的接口。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:39
 **/
public interface ApplicationContextAware extends Aware {
    /**
     * 设置应用程序上下文
     *
     * @param applicationContext 应用上下文
     * @throws BeansException 异常
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
