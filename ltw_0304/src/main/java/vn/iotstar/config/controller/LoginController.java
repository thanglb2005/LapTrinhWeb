package vn.iotstar.config.controller;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.config.model.User;
import vn.iotstar.config.service.UserService;
import vn.iotstar.config.service.impl.UserServiceImpl;
@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRemember = "on".equals(remember);

        if (username.isEmpty() || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu trống");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);   // giữ object User
            session.setAttribute("userId", user.getId()); // thêm id để CategoryController dùng
            session.setAttribute("username", user.getUserName()); // optional

            if (isRemember) {
                Cookie ck = new Cookie("username", username);
                ck.setMaxAge(30 * 60);
                resp.addCookie(ck);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        }
        else {
            req.setAttribute("alert", "Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}

