package cuit.pymjl.core.io;

/**
 * 资源加载器
 * 这个接口是提供不同资源的读取方式，比如 classPath、FileSystem、URL，屏蔽了具体的实现
 * 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装，分别判断是否为 ClassPath 、 URL 以及文件。
 * 这里不会让外部调用放知道过多的细节，而是仅关心具体调用结果即可。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:40
 **/
public interface ResourceLoader {
    /**
     * 从类路径加载的伪 URL 前缀：“classpath:”
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 通过路径获取资源
     *
     * @param location 位置
     * @return {@code Resource}
     */
    Resource getResource(String location);
}
