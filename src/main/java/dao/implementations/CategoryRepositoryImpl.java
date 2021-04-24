package dao.implementations;

import dao.services.CategoryRepository;
import entities.Category;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        entityManager.createQuery("update  Category category set category.isDeleted = true where category.id =:id").
                setParameter("id", id);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select category from Category category where category.isDeleted = false", Category.class).
                getResultList();
    }

    public List<Category> findByName(String name) {
        return entityManager.createQuery(
                "select category from Category category where category.isDeleted = false and category.name = :name",
                Category.class).setParameter("name", name).getResultList();
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }


}
