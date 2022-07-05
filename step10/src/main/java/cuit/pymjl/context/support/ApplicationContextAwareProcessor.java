package cuit.pymjl.context.support;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanPostProcessor;
import cuit.pymjl.context.ApplicationContext;
import cuit.pymjl.context.ApplicationContextAware;

/**
 * 由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，所以
 * 需要在 refresh 操作时，把 ApplicationContext 写入到一个包装的
 * BeanPostProcessor 中去，
 * 再由AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization方法调用。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:44
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
