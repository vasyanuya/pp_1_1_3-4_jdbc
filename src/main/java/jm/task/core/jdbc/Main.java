package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
//        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        System.out.println("User с именем — %s добавлен в базу данных" + (User)userDao.getName());
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        userDao.saveUser("Name4", "LastName4", (byte) 38);
        userDao.removeUserById(1);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}