package cuit.pymjl.beans.factory.support;


import cn.hutool.core.bean.BeanUtil;
import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.PropertyValue;
import cuit.pymjl.beans.PropertyValues;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:36
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 实例化对象的策略，jdk的默认实现是DefaultInstantiationStrategy，这是cglib的实现
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建bean实例
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     * @param args           有参构造函数的参数
     * @return {@code Object}
     * @throws BeansException 异常
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 1.真正的创建bean实例
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 2.给bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //将对象放入单例对象缓存中
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 创建bean实例
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名字
     * @param args           arg游戏
     * @return {@code Object}
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        // 1.获取bean的字节码
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 2.获取bean的所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                // 3.如果构造函数的参数个数与传入的参数个数一致，则对改构造函数进行赋值
                constructorToUse = ctor;
                break;
            }
        }
        // 4.根据对应的实例化策略，返回实例化的对象
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 填充属性值
     *
     * @param beanName       对象的名字
     * @param bean           对象
     * @param beanDefinition bean定义
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            //1.获取bean的属性值
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            //2.遍历属性值，给bean属性赋值
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                //3.如果属性值是一个bean的引用，则递归调用getBean方法，获取对象的实例(这里并没有处理循环依赖)
                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //4.给bean属性赋值
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
