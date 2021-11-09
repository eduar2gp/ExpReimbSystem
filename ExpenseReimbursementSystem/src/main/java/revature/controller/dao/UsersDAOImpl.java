package revature.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import revature.controller.utils.Logs;
import revature.model.User;

public class UsersDAOImpl implements UsersDAO {

    @Override
    public boolean insertUser(User user) {
        // INSERT INTO ers_users(user_name, user_password, user_first_name,
        // user_last_name, user_email, user_role_id )
        Connection connection;
        try {
            String sql = "INSERT INTO ers_users(user_name, user_password, user_first_name, user_last_name, user_email, user_role_id) VALUES(?, ?, ?, ?, ?, ?) RETURNING user_id";
            connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUserName());
            stm.setString(2, user.getUserPassword());
            stm.setString(3, user.getUserFirstName());
            stm.setString(4, user.getUserLastName());
            stm.setString(5, user.getUserEmail());
            stm.setInt(6, user.getUserRoleId());

            ResultSet resSet = stm.executeQuery();

            if (resSet.next()) {
                System.out.println(resSet.getInt(1));
                return true;
            }
            return false;

        } catch (SQLException e) {
            if (Logs.SAVE_LOGS) {
                Logs.log4j.error(e);
            }
            if (Logs.SHOW_LOGS) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public List<User> selectUsers() {
        List<User> listUsers = new ArrayList<>();
        Connection connection;
        try {
            connection = ConnectionFactory.getConnection();
            Statement stm;
            stm = connection.createStatement();
            ResultSet resSet = stm.executeQuery("SELECT * FROM ers_users");
            while (resSet.next()) {
                User user = new User(resSet.getInt("user_id"), resSet.getString("user_name"),
                        resSet.getString("user_password"), resSet.getString("user_first_name"),
                        resSet.getString("user_last_name"), resSet.getString("user_email"),
                        resSet.getInt("user_role_id"));
                listUsers.add(user);
            }
        } catch (SQLException e) {
            if (Logs.SAVE_LOGS) {
                Logs.log4j.error(e);
            }
            if (Logs.SHOW_LOGS) {
                e.printStackTrace();
            }
        }
        return listUsers;
    }

    @Override
    public User selectUser(String username, String password) {
        User user = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM ers_users WHERE user_email = ? AND user_password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet resSet = stm.executeQuery();
            if (resSet.next()) {
                user = new User(resSet.getInt("user_id"), resSet.getString("user_name"),
                        resSet.getString("user_password"), resSet.getString("user_first_name"),
                        resSet.getString("user_last_name"), resSet.getString("user_email"),
                        resSet.getInt("user_role_id"));
            }
        } catch (SQLException e) {
            if (Logs.SAVE_LOGS) {
                Logs.log4j.error(e);
            }
            if (Logs.SHOW_LOGS) {
                e.printStackTrace();
            }
        }
        return user;
    }
}