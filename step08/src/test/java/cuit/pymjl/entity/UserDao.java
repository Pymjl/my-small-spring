package cuit.pymjl.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 20:23
 **/
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    /**
     * 初始化方法,使用配置文件的init-method属性指定
     */
    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "Pymjl");
        hashMap.put("10002", "张三");
        hashMap.put("10003", "李四");
        hashMap.put("10004", "王五");
        hashMap.put("10005", "赵六");
        hashMap.put("10006", "钱七");
    }

    /**
     * 销毁方法,使用配置文件的destroy-method属性指定
     */
    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
