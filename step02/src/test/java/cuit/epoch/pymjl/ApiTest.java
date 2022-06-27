package cuit.epoch.pymjl;

import cuit.epoch.pymjl.beans.factory.config.BeanDefinition;
import cuit.epoch.pymjl.beans.factory.support.DefaultListableBeanFactory;
import cuit.epoch.pymjl.entity.User;
import org.junit.jupiter.api.Test;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:40
 **/
public class ApiTest {
    @Test
    void testMain() {
        // 1.先定义工厂类
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 2.创建beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        // 3.注册beanDefinition
        factory.registerBeanDefinition("user", beanDefinition);
        // 4.获取对象
        User user = (User) factory.getBean("user");
        user.sayHello();
        System.out.println(user);
        // 5.第二次获取对象
        User user1 = (User) factory.getBean("user");
        System.out.println(user1);
    }
}
