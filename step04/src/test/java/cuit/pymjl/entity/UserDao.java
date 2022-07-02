package cuit.pymjl.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 22:16
 **/
public class UserDao {
    private static final Map<Integer, String> users = new HashMap<>();

    static {
        users.put(1, "张三");
        users.put(2, "李四");
        users.put(3, "王五");
        users.put(4, "赵六");
        users.put(5, "田七");
        users.put(6, "Pymjl");
    }

    public String getUserNameById(Integer id) {
        return users.get(id);
    }
}
