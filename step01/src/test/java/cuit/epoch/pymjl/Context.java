package cuit.epoch.pymjl;

import cuit.epoch.pymjl.entity.User;
import org.junit.jupiter.api.Test;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 19:34
 **/
public class Context {
    @Test
    void ApiTest() {
        BeanDefinition beanDefinition = new BeanDefinition(new User("pymjl", "123456"));
        BeanFactory factory = new BeanFactory();
        factory.registerBeanDefinition("user", beanDefinition);
        System.out.println(factory.getBean("user"));
    }
}
