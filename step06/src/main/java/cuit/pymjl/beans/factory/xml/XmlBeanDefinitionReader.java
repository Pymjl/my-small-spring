package cuit.pymjl.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.PropertyValue;
import cuit.pymjl.beans.factory.config.BeanDefinition;
import cuit.pymjl.beans.factory.config.BeanReference;
import cuit.pymjl.beans.factory.support.AbstractBeanDefinitionReader;
import cuit.pymjl.beans.factory.support.BeanDefinitionRegistry;
import cuit.pymjl.core.io.Resource;
import cuit.pymjl.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对xml文件进行解析，并且将解析后的bean定义信息放入bean定义注册表中
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 17:01
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 加载BeanDefinition
     *
     * @param resource 资源
     * @throws BeansException 豆子例外
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 如果传入的是文件路径，这会通过 ResourceLoader 获取资源，如果传入的是资源，那么直接使用。
     * ResourceLoader 会选择对应的加载方式
     *
     * @param location 位置
     * @throws BeansException 豆子例外
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 如果传入的是文件路径，这会通过 ResourceLoader 获取资源，如果传入的是资源，那么直接使用。
     * ResourceLoader 会选择对应的加载方式
     *
     * @param locations 资源文件路径数组
     * @throws BeansException 异常
     */
    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 加载BeanDefinition的具体实现方法，对xml进行解析，并且将解析后的bean定义信息放入bean定义注册表中
     *
     * @param inputStream 输入流
     * @throws ClassNotFoundException 类没有发现异常
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // 1. 获取xml文档对象
        Document doc = XmlUtil.readXML(inputStream);
        // 2. xml文件的获取根节点
        Element root = doc.getDocumentElement();
        // 3. 获取根节点下的所有子节点
        NodeList childNodes = root.getChildNodes();
        // 4. 遍历所有子节点
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 5.判断元素的类型，是否是元素节点
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            // 6.判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            // 7.解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 8.获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 9.优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 10.定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 11.读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                // 12.解析标签：property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 13.获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 14.创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 15.注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
