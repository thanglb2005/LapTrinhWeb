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
    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [User](username,password,email,fullname,phone,roleid,createddate) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getRoleid());
            ps.setDate(7, user.getCreatedDate());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT 1 FROM [User] WHERE username=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT 1 FROM [User] WHERE email=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM [User] WHERE email=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassWord(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setFullName(rs.getString("fullname"));
                u.setPhone(rs.getString("phone"));
                u.setRoleid(rs.getInt("roleid"));
                u.setCreatedDate(rs.getDate("createddate"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE [User] SET password=? WHERE id=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getPassWord());
            ps.setInt(2, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
