package Dao;

import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by wxk on 2017/3/30.
 */
public class UserDAOImpI implements IUserDAO {
    private Connection conn = null;//定义数据库连接对象
    private PreparedStatement pstmt = null;//定义数据库操作对象

    //设置数据库连接
    public UserDAOImpI(Connection conn){
        this.conn = conn;
    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "select userpri from user where username=? and password=? and usertype=?";
            pstmt = conn.prepareStatement(sql);//实例化操作
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUsertype());
            ResultSet rSet = pstmt.executeQuery();//取得结果
            if (rSet.next()) {
                //读取用户权限值
                user.setUserpri(rSet.getInt(1));
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            //关闭操作
            if (null != pstmt) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }

        }
        return flag;
    }

    public void addUser(User user) throws Exception {
        try {
            String sql = "insert into user values(?;?;?;?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUsertype());
            pstmt.setInt(4, user.getUserpri());
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (null != pstmt) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
