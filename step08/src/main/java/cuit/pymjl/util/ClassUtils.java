package cuit.pymjl.util;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:32
 **/
public class ClassUtils {
    /**
     * 获取默认的 ClassLoader
     *
     * @return {@code ClassLoader}
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
