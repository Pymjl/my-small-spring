package cuit.pymjl.beans.factory;


/**
 * Callback that allows a bean to be aware of the bean
 * {@link ClassLoader class loader}; that is, the class loader used by the
 * present bean factory to load bean classes.
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 21:36
 **/
public interface BeanClassLoaderAware extends Aware {
    /**
     * 设置类加载器
     *
     * @param classLoader 类加载器
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
