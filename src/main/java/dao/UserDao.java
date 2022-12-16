package dao;

import domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {
    @Autowired
    PasswordEncoder passwordEncoder;
    Connection connection = null;
    ResultSet rs = null;

    public void insert(UserDto userDto) throws SQLException {
        connection();

        PreparedStatement pstmt = connection.prepareStatement("insert into users (id, password) values (?, ?)");

        pstmt.setString(1, userDto.getId());
        pstmt.setString(2, passwordEncoder.encode(userDto.getPassword()));
        pstmt.executeUpdate();
    }

    public boolean isMatches(String inputPassword, String dbPassword) {
        return passwordEncoder.matches(inputPassword, dbPassword);
    }

    public String findPassword(String id) throws SQLException {
        connection();

        PreparedStatement pstmt = connection.prepareStatement("select password from users where id = ?");
        System.out.println("아이디 : " + id);

        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        if(rs.next()) {
            return rs.getString("password");
        }else {
            return null;
        }
    }

    public void connection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String pwd = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("DB connect Success!!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

