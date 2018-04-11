package Dao;

import User.User;

/**
 * Created by wxk on 2017/3/30.
 */
public class UserDAOProxy implements IUserDAO {
    //定义数据库连接
    private DatabaseConnection dbc = null;
    //定义DAO接口
    private IUserDAO dao;

    public UserDAOProxy() {
        try {
            //实例化数据库连接
            dbc = new DatabaseConnection();
            dao = new UserDAOImpI(dbc.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean findLogin(User user) throws Exception {
        boolean flag;

        try {
            flag = dao.findLogin(user);
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

    public void addUser(User user) throws Exception {
        try {
            dao.addUser(user);
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
    }
}
