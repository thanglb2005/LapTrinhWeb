package vn.iotstar.config.service.impl;
import vn.iotstar.config.dao.UserDao;
import vn.iotstar.config.dao.impl.UserDaoImpl;
import vn.iotstar.config.model.User;
import vn.iotstar.config.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null && password.equals(user.getPassWord())) return user;
        return null;
    }
}
