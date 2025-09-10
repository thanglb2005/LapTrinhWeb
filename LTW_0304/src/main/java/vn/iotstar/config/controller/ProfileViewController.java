package vn.iotstar.config.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.config.model.User;

@WebServlet("/profile")
public class ProfileViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account"); // đổi từ "user" -> "account"

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
            return;
        }

        req.setAttribute("user", user); // để JSP vẫn dùng ${user}
        req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
    }
}
