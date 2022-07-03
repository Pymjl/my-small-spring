package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.factory.BeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:12
 **/
public interface ConfigurableBeanFactory {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
