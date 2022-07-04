package cuit.pymjl.entity;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 0:20
 **/
public class UserService {
    private String Id;
    private String company;
    private String address;
    private UserDao userDao;

    public String queryUserInfo() {
        return "{username=" + userDao.queryUserName(Id) + ", company=" + company + ", address=" + address + "}";
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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
