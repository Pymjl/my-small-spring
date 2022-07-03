package cuit.pymjl;

import cn.hutool.core.io.IoUtil;
import cuit.pymjl.beans.factory.support.DefaultListableBeanFactory;
import cuit.pymjl.beans.factory.xml.XmlBeanDefinitionReader;
import cuit.pymjl.core.io.DefaultResourceLoader;
import cuit.pymjl.core.io.Resource;
import cuit.pymjl.entity.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:38
 **/
public class ApiTest {
    private DefaultResourceLoader resourceLoader;

    @BeforeEach
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:druid.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserById();
        System.out.println("测试结果：" + result);
    }

}
