package vn.iotstar.config.dao;

import vn.iotstar.config.model.User;

public interface UserDao {
    User get(String username);                // Login
    void insert(User user);                   // Thêm user mới (Register)
    boolean checkExistUsername(String username); // Kiểm tra trùng username
    boolean checkExistEmail(String email);    // Kiểm tra trùng email
}
