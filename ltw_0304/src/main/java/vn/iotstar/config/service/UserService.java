package vn.iotstar.config.service;

import vn.iotstar.config.model.User;

public interface UserService {
    // Đăng nhập
    User login(String username, String password);

    // Đăng ký
    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);

    // Quên mật khẩu
    User findByEmail(String email);
    void update(User user);
}
