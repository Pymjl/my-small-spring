package cuit.pymjl.beans.factory;

import cuit.pymjl.beans.BeansException;

import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * <p>
 * 是一个扩展 Bean 工厂接口的接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:06
 **/
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return {@code String[]}
     */
    String[] getBeanDefinitionNames();
}
