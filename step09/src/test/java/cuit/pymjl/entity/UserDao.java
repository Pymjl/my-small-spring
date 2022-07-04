package cuit.pymjl.entity;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/5 0:16
 **/
public interface UserDao {
    /**
     * 查询用户名
     *
     * @param Id id
     * @return {@code String}
     */
    String queryUserName(String Id);
}
