package Dao;
import User.User;

/**
 * Created by wxk on 2017/3/30.
 */
public interface IUserDAO {
        boolean findLogin(User user) throws Exception;
        void addUser(User user) throws Exception;
}
