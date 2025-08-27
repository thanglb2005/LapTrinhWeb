package vn.iotstar.config.dao;
import vn.iotstar.config.model.User;

public interface UserDao {
    User get(String username);
}