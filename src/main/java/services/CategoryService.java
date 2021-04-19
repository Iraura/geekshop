package services;

import dto.CategoryRecord;
import entities.Category;

import java.util.List;

public interface CategoryService {

    CategoryRecord createCategory( CategoryRecord record);

    List<CategoryRecord> getCategories();

    void deleteCategory( CategoryRecord category);
}
