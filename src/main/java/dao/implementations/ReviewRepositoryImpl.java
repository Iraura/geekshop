package dao.implementations;

import dao.services.ReviewRepository;
import entities.Element;
import entities.Review;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Review review){
        entityManager.persist(review);
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        entityManager.createQuery("update Review review set review.isDeleted = true where review.id = :id")
                .setParameter("id",id);
    }

    @Override
    public List<Review> getAllByUserId(Long userId) {
        return entityManager.createQuery("select review from Review review where review.client.id =:id " +
                "and review.isDeleted = false", Review.class).setParameter("id",userId).getResultList();
    }

    @Override
    public List<Review> getAllByProductId(Long productId) {
        return entityManager.createQuery("select review from Review review where review.product.id =:id " +
                "and review.isDeleted = false", Review.class).setParameter("id",productId).getResultList();
    }

}
