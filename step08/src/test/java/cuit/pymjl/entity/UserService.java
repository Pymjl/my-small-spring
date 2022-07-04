package cuit.pymjl.entity;

import cuit.pymjl.beans.BeansException;
import cuit.pymjl.beans.factory.*;
import cuit.pymjl.context.ApplicationContext;
import cuit.pymjl.context.ApplicationContextAware;

/**
 * 手动实现 InitializingBean 和 DisposableBean 接口
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/4 20:24
 **/
public class UserService implements BeanNameAware, BeanClassLoaderAware,
        ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String Id;
    private String company;
    private String address;
    private UserDao userDao;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    public String queryUserInfo() {
        return "User{name=" + userDao.queryUserName(Id) + ", company=" + company + ", address=" + address + "}";
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
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


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
