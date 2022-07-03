package cuit.pymjl;

import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.support.DefaultListableBeanFactory;
import cuit.pymjl.entity.User;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/1 21:39
 **/
public class Context {
    public static void main(String[] args) {
        // 1.创建一个DefaultListableBeanFactory对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册一个User类型的bean
        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);

        //3.获取User类型的bean,User对象只有有参构造函数，所以在获取对象时必须传入参数，否则报错
        User user = (User) beanFactory.getBean("user", "Pymjl");
//        User user = (User) beanFactory.getBean("user"); 无参数，报错
        user.sayHello();
    }
}
