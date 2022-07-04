package cuit.pymjl.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 16:42
 **/
public class DefaultResourceLoader implements ResourceLoader {
    /**
     * 默认通过类加载器来加载资源
     *
     * @param location 位置
     * @return {@code Resource}
     */
    @Override
    public Resource getResource(String location) {
        // 1.断言位置不为空
        Assert.notNull(location, "Location must not be null");
        // 2.如果位置是以 classpath: 开头，则通过类加载器加载资源
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            // 3.如果位置不是以 classpath: 开头，则通过 URL 对象来加载资源
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 4.如果位置不是以 classpath: 开头，也不是 URL 对象，则通过文件系统来加载资源
                return new FileSystemResource(location);
            }
        }
    }

}
