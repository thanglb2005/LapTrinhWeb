package vn.iotstar.config.service;
import vn.iotstar.config.model.User;

public interface UserService 
{
	 // Đăng nhập ( Ví dụ 1)
    User login(String username, String password);

    // Đăng ký (thêm mới)
    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);
}
