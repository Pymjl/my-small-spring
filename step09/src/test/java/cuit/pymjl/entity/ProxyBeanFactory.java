package cuit.pymjl.entity;

import cuit.pymjl.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是一个实现接口 FactoryBean 的代理类 ProxyBeanFactory 名称，主要是模拟了
 * UserDao 的原有功能，类似于 MyBatis 框架中的代理操作。
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 0:16
 **/
public class ProxyBeanFactory implements FactoryBean<UserDao> {
    /**
     * 提供的就是一个 InvocationHandler 的代理对象，当有方法调用的
     * 时候，则执行代理对象的功能。
     *
     * @return {@code UserDao}
     * @throws Exception 异常
     */
    @Override
    public UserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) return this.toString();
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "Pymjl");
            hashMap.put("10002", "张三");
            hashMap.put("10003", "李四");
            hashMap.put("10004", "王五");
            hashMap.put("10005", "赵六");
            hashMap.put("10006", "钱七");
            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        };
        return (UserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{UserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
