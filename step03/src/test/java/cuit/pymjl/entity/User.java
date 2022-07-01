package cuit.pymjl.entity;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/6/27 20:42
 **/
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void sayHello() {
        System.out.println("你好啊，" + username + " !");
    }
}
