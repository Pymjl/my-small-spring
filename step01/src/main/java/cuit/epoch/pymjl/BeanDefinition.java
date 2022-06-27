package cuit.epoch.pymjl;

/**
 * 这个类是对对象的描述，在Factory中通过BeanDefinition来创建对象
 * 最开始我们先直接存放对象的示例来简化操作
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 19:24
 **/
public class BeanDefinition {
    /**
     * 实例对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
