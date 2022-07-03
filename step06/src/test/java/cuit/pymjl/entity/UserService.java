package cuit.pymjl.entity;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 0:03
 **/
public class UserService {
    private Integer id;
    private UserDao userDao;
    private String address;
    private String company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String queryUserInfo() {
        return "查询到用户名为：" + userDao.getUserName(id) + "，地址为：" + address + "，公司为：" + company;
    }
}
