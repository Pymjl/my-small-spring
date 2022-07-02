package cuit.pymjl.beans.factory.config;

/**
 * 对象的引用
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 18:05
 **/
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
