package vn.iotstar.config.service.impl;
import java.sql.Date;
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
    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        // Nếu tồn tại username hoặc email -> false
        if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email)) return false;

        // Tạo user mới và chèn DB
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        User u = new User();
        u.setUserName(username);
        u.setPassWord(password);
        u.setEmail(email);
        u.setFullName(fullname);
        u.setPhone(phone);
        u.setRoleid(3);  // mặc định user thường
        u.setCreatedDate(date);

        userDao.insert(u);
        return true;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }
}
