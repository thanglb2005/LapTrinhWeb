package vn.iotstar.config.dao.impl;
import java.sql.*;
import vn.iotstar.config.DBConnect;
import vn.iotstar.config.dao.UserDao;
import vn.iotstar.config.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE username=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassWord(rs.getString("password"));
                u.setRoleid(rs.getInt("roleid"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
