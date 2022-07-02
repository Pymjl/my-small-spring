package cuit.pymjl;

import cuit.pymjl.beans.PropertyValue;
import cuit.pymjl.beans.PropertyValues;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.BeanReference;
import cuit.pymjl.beans.factory.support.DefaultListableBeanFactory;
import cuit.pymjl.entity.UserDao;
import cuit.pymjl.entity.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 22:15
 **/
public class ApiTest {
    @Test
    void testMain() {
        //1.创建一个BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //2.注册UserDao的BeanDefinition
        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        //3.添加对象的属性值
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue propertyValue = new PropertyValue("id", 6);
        PropertyValue propertyValue1 = new PropertyValue("userDao", new BeanReference("userDao"));
        propertyValues.addPropertyValue(propertyValue);
        propertyValues.addPropertyValue(propertyValue1);
        //4.注册UserService的BeanDefinition
        factory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        //5.获取UserService的实例
        UserService userService = (UserService) factory.getBean("userService", UserService.class);
        //6.调用UserService的方法
        userService.queryUserById();

    }
}
