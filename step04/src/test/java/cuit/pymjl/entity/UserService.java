package cuit.pymjl.entity;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/2 22:15
 **/
public class UserService {
    private UserDao userDao;
    private Integer id;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void queryUserById() {
        System.out.println("查询到用户名为：" + userDao.getUserNameById(id));
    }

}
