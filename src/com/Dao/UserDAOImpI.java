package com.Dao;

import com.User.User;

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
            String sql = "select name from user where name=? and password=? and usertype=?";
            pstmt = conn.prepareStatement(sql);//实例化操作
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUsertype());
            ResultSet rSet = pstmt.executeQuery();//取得结果
            if (rSet.next()) {
                user.setUsername(rSet.getString(1));//取得用户名
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
}
