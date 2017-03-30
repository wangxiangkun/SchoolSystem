package com.Dao;
import com.User.User;

/**
 * Created by wxk on 2017/3/30.
 */
public interface IUserDAO {
        public boolean findLogin(User user) throws Exception;
}
