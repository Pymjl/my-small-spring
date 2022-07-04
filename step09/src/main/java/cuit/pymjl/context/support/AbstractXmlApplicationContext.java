package cuit.pymjl.context.support;

import cuit.pymjl.beans.factory.support.DefaultListableBeanFactory;
import cuit.pymjl.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 23:27
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 创建 XmlBeanDefinitionReader 对象,因为该类是DefaultResourceLoader 的子类，所以可以直接传参使用
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        // 读取配置文件，并将 Bean 对象的定义和注册到 BeanFactory 中
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            // 加载配置文件,并将 BeanDefinition 对象注册到容器中
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置文件路径，抽象方法，由子类实现
     *
     * @return {@code String[]}
     */
    protected abstract String[] getConfigLocations();

}
