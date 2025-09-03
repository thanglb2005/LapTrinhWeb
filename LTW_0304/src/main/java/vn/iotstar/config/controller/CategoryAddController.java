package vn.iotstar.config.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.config.model.Category;
import vn.iotstar.config.service.CategoryService;
import vn.iotstar.config.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/admin/add-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String icon = req.getParameter("icon");
        System.out.println(">>> [ADD] name=" + name + ", icon=" + icon);

        HttpSession session = req.getSession();
        vn.iotstar.config.model.User user = (vn.iotstar.config.model.User) session.getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login"); // hoặc xử lý tùy ý
            return;
        }

        Category c = new Category();
        c.setName(name);
        c.setIcon(icon);
        c.setUserId(user.getId());

        service.insert(c);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }

}
