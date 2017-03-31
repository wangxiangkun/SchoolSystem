package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wxk on 2017/3/29.
 */
public class DatabaseConnection {
    //定义数据库驱动程序
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String DBURL = "jdbc:mysql://localhost:3306/school_system";
    private static final String DBUSER = "root";
    private static final String DBPASS = "123456";
    private Connection connection = null;

    public DatabaseConnection() throws Exception {
        try {
            //数据库操作可能出现异常
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        } catch (Exception exception) {
            throw exception;
        } finally {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
