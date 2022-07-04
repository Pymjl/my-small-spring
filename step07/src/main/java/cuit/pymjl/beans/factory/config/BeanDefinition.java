package cuit.pymjl.beans.factory.config;

import cuit.pymjl.beans.PropertyValues;

/**
 * 上一个模块我们是直接存放的对象的实例，这次我们把对象的创建交给容器来管理
 * 并且还需要考虑单例对象
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:10
 **/
public class BeanDefinition {
    /**
     * 对象的字节码
     */
    private Class<?> beanClass;

    /**
     * 对象的属性值，是一个集合
     */
    private PropertyValues propertyValues;

    /**
     * 对象初始化时要init的方法名称，由用户指定配置文件中的init-method属性
     */
    private String initMethodName;

    /**
     * 对象销毁时要操作的方法名称，由用户指定配置文件中的destroy-method属性
     */
    private String destroyMethodName;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
