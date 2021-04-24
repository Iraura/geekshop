package dao.implementations;

import dao.services.ProductRepository;
import entities.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(Long productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    @Transactional
    public void deleteById(Integer productId) {
        entityManager.createQuery(
                "update Product product set product.isDeleted = true where product.id = :id")
                .setParameter("id", productId);
    }

    @Override
    public List<Product> getAvailable() {
        return entityManager.createQuery(" select product from Product product where  product.count > 0 and product.isDeleted = false", Product.class).getResultList();
    }
}
