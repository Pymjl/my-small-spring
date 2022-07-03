package cuit.pymjl.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 定义 Resource 接口，提供获取 InputStream 流的方法，接下来再分别实现三种
 * 不同的流文件操作： classPath 、 FileSystem 、 URL
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:30
 **/
public interface Resource {
    /**
     * 获取输入流
     *
     * @return {@code InputStream}
     * @throws IOException ioexception
     */
    InputStream getInputStream() throws IOException;
}
