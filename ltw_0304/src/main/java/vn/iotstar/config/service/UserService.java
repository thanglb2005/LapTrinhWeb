package vn.iotstar.config.service;
import vn.iotstar.config.model.User;

public interface UserService {
    User login(String username, String password);
}
