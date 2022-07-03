package cuit.pymjl.common;


import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.PropertyValue;
import cuit.pymjl.beans.PropertyValues;
import cuit.pymjl.beans.factory.ConfigurableListableBeanFactory;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动(改)"));
    }

}
