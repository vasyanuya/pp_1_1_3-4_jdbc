package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    static UserDao ud = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
        ud.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        ud.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        ud.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        ud.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return ud.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        ud.cleanUsersTable();
    }
}
