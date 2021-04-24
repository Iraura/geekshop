package dao.implementations;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.services.OrderRepository;
import entities.Order;
import liquibase.pro.packaged.O;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteById(Long orderId) {
        entityManager.createQuery(
                "update Order order set order.isDeleted = true where order.id = :id")
                .setParameter("id", orderId);
    }

    @Override
    public Order findById(Long orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    @Transactional
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findByClientId(Long userId) {
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", userId).getResultList();
    }

    @Override
    public List<Order> getAll() {
        return entityManager.createQuery(
                "select order from Order order where   order.isDeleted = false ", Order.class).getResultList();
    }
}
