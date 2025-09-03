package vn.iotstar.config.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.config.model.Category;
import vn.iotstar.config.service.CategoryService;
import vn.iotstar.config.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/edit")
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = service.get(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/admin/edit-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String icon = req.getParameter("icon");

        Category c = new Category();
        c.setId(id);
        c.setName(name);
        c.setIcon(icon);

        service.edit(c);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
