package com.Dao;

import com.User.User;

/**
 * Created by wxk on 2017/3/30.
 */
public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;//定义数据库连接
    private IUserDAO dao = null;//定义DAO接口

    public UserDAOProxy(){
        try {
            //实例化数据库连接
            dbc = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao = new UserDAOImpI(dbc.getConnection());

    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;

        try {
            flag = dao.findLogin(user);
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }
}
