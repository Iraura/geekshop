package services.implementations;

import dao.services.CategoryRepository;
import dto.CategoryRecord;
import entities.Category;
import services.CategoryService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryRecord> getCategories() {
        return categoryRepository.findAll().stream().map(CategoryRecord::new).collect(Collectors.toList());
    }

    @Override
    public CategoryRecord createCategory(CategoryRecord record) {
        categoryRepository.save(new Category(record));
        return  record;
    }

    @Override
    public void deleteCategory(CategoryRecord category) {
        categoryRepository.deleteById(category.getId());
    }
}
