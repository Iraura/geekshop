package dao.services;


import entities.Product;

import java.util.List;

public interface ProductRepository {

    void save (Product product);

    void deleteById(Integer productId);

    Product findById(Long productId);

    List<Product> getAvailable();

}
