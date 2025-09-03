package vn.iotstar.config.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.config.dao.CategoryDao;
import vn.iotstar.config.model.Category;
import vn.iotstar.config.DBConnect;

public class CategoryDaoImpl extends DBConnect implements CategoryDao {
    @Override
    public void insert(Category category) {
    	String sql = "INSERT INTO Category (cate_name, icons, user_id) VALUES (?, ?, ?)";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.println(">>> GHI DB: " + category.getName() + " | " + category.getIcon()); // thêm log

            ps.setString(1, category.getName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getUserId()); 

            int rows = ps.executeUpdate();
            System.out.println(">>> Rows affected: " + rows); // thêm log dòng ảnh hưởng

        } catch (Exception e) {
            System.out.println(">>> Lỗi khi insert:");
            e.printStackTrace(); // in lỗi nếu có
        }
    }

    @Override
    public void edit(Category category) {
        String sql = "UPDATE Category SET cate_name=?, icons=? WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM Category WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("cate_id"));
                c.setName(rs.getString("cate_name"));
                c.setIcon(rs.getString("icons"));
                return c;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("cate_id"));
                c.setName(rs.getString("cate_name"));
                c.setIcon(rs.getString("icons"));
                list.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
