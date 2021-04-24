package dao.services;

import entities.Category;

import java.util.List;

public interface CategoryRepository {

    void save(Category category);

    void deleteById(Integer id);

    List<Category> findAll();

    List<Category> findByName(String name);

    Category findById(Long id);

}
