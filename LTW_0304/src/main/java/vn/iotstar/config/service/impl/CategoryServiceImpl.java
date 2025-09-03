package vn.iotstar.config.service.impl;

import java.util.List;
import vn.iotstar.config.dao.CategoryDao;
import vn.iotstar.config.dao.impl.CategoryDaoImpl;
import vn.iotstar.config.model.Category;
import vn.iotstar.config.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    public void insert(Category c) { dao.insert(c); }
    public void edit(Category c) { dao.edit(c); }
    public void delete(int id) { dao.delete(id); }
    public Category get(int id) { return dao.get(id); }
    public List<Category> getAll() { return dao.getAll(); }
}
