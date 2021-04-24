package dao.implementations;

import dao.services.ElementRepository;
import entities.Element;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ElementRepositoryImpl implements ElementRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Element element) {
        entityManager.persist(element);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        entityManager.createQuery("update Element element set element.isDeleted = true where element.id = :id")
                .setParameter("id", id);
    }

    @Override
    public List<Element> getAllByOrderId(Long orderId) {
        return entityManager.createQuery("select element from Element element where element.order.id =:id " +
                "and element.isDeleted = false", Element.class).setParameter("id", orderId).getResultList();
    }

    @Override
    public List<Element> getAllByProductId(Integer productId) {
        return entityManager.createQuery("select element from Element element where element.product.id =:id " +
                "and element.isDeleted = false", Element.class).setParameter("id", productId).getResultList();
    }

    @Override
    public List<Element> getAllByProductIdOrderByCount(Integer productId) {
        return entityManager.createQuery("select element from Element element where element.product.id =:id " +
                "and element.isDeleted = false order by element.count", Element.class).setParameter("id", productId).getResultList();
    }


}
