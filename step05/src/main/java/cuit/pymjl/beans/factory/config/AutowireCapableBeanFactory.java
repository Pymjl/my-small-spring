package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.factory.BeanFactory;

/**
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:11
 **/
public interface AutowireCapableBeanFactory extends BeanFactory {

}
