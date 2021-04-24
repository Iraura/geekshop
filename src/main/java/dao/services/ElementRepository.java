package dao.services;

import entities.Element;

import java.util.List;

public interface ElementRepository {

    void save(Element element);

    List<Element> getAllByOrderId(Long orderId);

    List<Element> getAllByProductId(Integer productId);

    void deleteById(Long id);

    List<Element> getAllByProductIdOrderByCount(Integer productId);

}
