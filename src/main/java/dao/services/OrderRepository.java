package dao.services;

import entities.Order;

import java.util.List;

public interface OrderRepository {

    void deleteById(Long orderId);

    Order findById(Long orderId);

    List<Order> findByClientId(Long userId);

    void save(Order order);

    List<Order> getAll();

}
