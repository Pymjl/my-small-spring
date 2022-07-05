package cuit.pymjl.context;

import cuit.pymjl.beans.factory.HierarchicalBeanFactory;
import cuit.pymjl.beans.factory.ListableBeanFactory;
import cuit.pymjl.core.io.ResourceLoader;

/**
 * 应用上下文
 * 为应用程序提供配置的中央接口。这在应用程序运行时是只读的，但如果实现支持，则可以重新加载。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:06
 **/
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
