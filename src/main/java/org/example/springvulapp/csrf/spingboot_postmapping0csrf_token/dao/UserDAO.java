package org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.dao;

import org.example.springvulapp.csrf.spingboot_postmapping0csrf_token.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Các thông tin kết nối cơ sở dữ liệu
    private static final String URL = "jdbc:mariadb://localhost:3306/springvulapp";  // Thay đổi URL cho phù hợp
    private static final String USER = "root";  // Thay đổi theo thông tin của bạn
    private static final String PASSWORD = "";  // Thay đổi theo mật khẩu của bạn

    // Phương thức kết nối với DB
    private Connection getConnection() throws SQLException {
        try {
            // Tải driver MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            // Kết nối đến DB
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MariaDB JDBC Driver not found.", e);
        }
    }

    public Boolean checkLogin(User user) throws SQLException {
        Connection connection = getConnection();
        String sql = "select * from users where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return true;
        }
        return false;
    }
    public String updateEmail(User user, String email) throws SQLException {
//        String sql = "select * from users where username = '"+user.getUsername()+"'";
//        List<User> users = new ArrayList<>();
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        ResultSet resultSet = statement.executeQuery(sql);
        String sql = "update users set email = ? where id = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1, email);
        ps.setInt(2, user.getId());
        int rowUpdated = ps.executeUpdate();
        if(rowUpdated > 0) {
            user.setEmail(email);
            return "success";
        }else {
            return "fail";
        }
    }

}
