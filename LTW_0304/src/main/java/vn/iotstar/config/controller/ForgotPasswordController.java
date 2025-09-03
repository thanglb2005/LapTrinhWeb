package vn.iotstar.config.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.config.model.User;
import vn.iotstar.config.service.UserService;
import vn.iotstar.config.service.impl.UserServiceImpl;

@WebServlet("/forgot")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPass = request.getParameter("newPassword");

        User user = userService.findByEmail(email);
        if (user != null) {
            user.setPassWord(newPass); // sửa ở đây
            userService.update(user);

            request.setAttribute("alert", "Đổi mật khẩu thành công. Mời bạn đăng nhập lại.");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        } else {
            request.setAttribute("alert", "Email không tồn tại trong hệ thống.");
            request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
        }
    }
}
