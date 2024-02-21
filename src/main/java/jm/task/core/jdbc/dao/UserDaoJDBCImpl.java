package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private Connection con = getConnection();

    public void createUsersTable() throws SQLException {
        Statement stmnt = null;
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age TINYINT )";
            stmnt = con.createStatement();
            stmnt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (stmnt != null) {
//                stmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
    }

    public void dropUsersTable() throws SQLException {
        Statement stmnt = null;
        try {
            String sql = "DROP TABLE IF EXISTS Users";
            stmnt = con.createStatement();
            stmnt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (stmnt != null) {
//                stmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement prStmnt = null;
        try {
            String sql = "INSERT INTO Users (name, lastName, age) VALUES(?, ?, ?)";
            prStmnt = con.prepareStatement(sql);

            prStmnt.setString(1, name);
            prStmnt.setString(2, lastName);
            prStmnt.setByte(3, age);

            prStmnt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (prStmnt != null) {
//                prStmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
    }

    public void removeUserById(long id) throws SQLException {
        PreparedStatement prStmnt = null;
        try {
            String sql = "DELETE FROM Users WHERE id=?";
            prStmnt = con.prepareStatement(sql);
            prStmnt.setLong(1, id);
            prStmnt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (prStmnt != null) {
//                prStmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT id, name, lastName, age FROM Users";

        Statement stmnt = null;
        try {
            stmnt = con.createStatement();
            ResultSet rSet = stmnt.executeQuery(sql);

            while (rSet.next()) {
                User user = new User();
                user.setId(rSet.getLong("id"));
                user.setName(rSet.getString("name"));
                user.setLastName(rSet.getString("lastName"));
                user.setAge(rSet.getByte("age"));

                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (stmnt != null) {
//                stmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        Statement stmnt = null;
        try {
            String sql = "TRUNCATE TABLE Users";
            stmnt = con.createStatement();
            stmnt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            if (stmnt != null) {
//                stmnt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
    }
}
