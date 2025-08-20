package thang.vn.session;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login2"})   // đổi urlPatterns cho phù hợp
public class Login2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Mở form login khi truy cập /login2 trực tiếp
        req.getRequestDispatcher("/Login2.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Demo kiểm tra
        if ("trungnh".equals(username) && "123".equals(password)) {
            // Lưu thông tin vào session
            HttpSession session = request.getSession();   // tạo mới nếu chưa có
            session.setAttribute("name", username);

        } else {
            // Sai: in thông báo + include lại form
            PrintWriter out = response.getWriter();
            out.println("<p style='color:red'>Tài khoản hoặc mật khẩu không chính xác</p>");
            request.getRequestDispatcher("/Login2.html").include(request, response);
            out.close();
        }
    }
}