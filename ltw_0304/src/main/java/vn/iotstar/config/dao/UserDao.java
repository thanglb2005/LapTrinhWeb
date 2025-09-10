package vn.iotstar.config.dao;

import vn.iotstar.config.model.User;

public interface UserDao {
    User get(String username);                     // Login
    void insert(User user);                        // Thêm user mới (Register)
    boolean checkExistUsername(String username);   // Kiểm tra trùng username
    boolean checkExistEmail(String email);         // Kiểm tra trùng email

    // ===== Quên mật khẩu =====
    User findByEmail(String email);   // tìm user theo email
    void update(User user);           // cập nhật lại thông tin user (mật khẩu mới)
    
    void updateProfile(User user);

}
