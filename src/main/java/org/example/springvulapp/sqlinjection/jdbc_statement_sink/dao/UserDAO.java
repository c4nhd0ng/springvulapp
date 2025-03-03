package org.example.springvulapp.sqlinjection.jdbc_statement_sink.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.springvulapp.sqlinjection.jdbc_statement_sink.model.User;

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

    public List<User> findByUsername(User user) throws SQLException {
        String sql = "select * from users where username = '"+user.getUsername()+"'";
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            User user1 = new User();
            user1.setId(resultSet.getInt("id"));
            user1.setUsername(resultSet.getString("username"));
            user1.setEmail(resultSet.getString("email"));
            user1.setPassword(resultSet.getString("password"));
            users.add(user1);
        }
        return users;

    }

}

