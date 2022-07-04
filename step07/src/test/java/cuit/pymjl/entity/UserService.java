package cuit.pymjl.entity;

import cuit.pymjl.beans.factory.DisposableBean;
import cuit.pymjl.beans.factory.InitializingBean;

/**
 * 手动实现 InitializingBean 和 DisposableBean 接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 20:24
 **/
public class UserService implements InitializingBean, DisposableBean {
    private String Id;
    private String company;
    private String address;
    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String queryUserInfo() {
        return "User{name=" + userDao.queryUserName(Id) + ", company=" + company + ", address=" + address + "}";
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
