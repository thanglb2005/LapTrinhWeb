package vn.iotstar.config.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.config.dao.impl.UserDaoImpl;
import vn.iotstar.config.model.User;

@WebServlet("/profile/update")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 10 * 1024 * 1024,
    maxRequestSize = 20 * 1024 * 1024
)
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account"); // đổi từ "user" -> "account"

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
            return;
        }

        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");

        Part filePart = req.getPart("avatar");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (!fileName.isEmpty()) {
            String uploadDir = req.getServletContext().getRealPath("/uploads");
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) uploadFolder.mkdirs();

            filePart.write(uploadDir + File.separator + fileName);
            user.setAvatar(fileName);
        }

        user.setFullName(fullName);
        user.setPhone(phone);

        new UserDaoImpl().updateProfile(user);

        // update lại session với key "account"
        session.setAttribute("account", user);
        
        resp.sendRedirect(req.getContextPath() + "/profile?success=1");

    }
}
