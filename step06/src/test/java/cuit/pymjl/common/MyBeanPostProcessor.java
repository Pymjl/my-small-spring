package cuit.pymjl.common;


import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.config.BeanPostProcessor;
import cuit.pymjl.entity.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setAddress("北京(改)");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
