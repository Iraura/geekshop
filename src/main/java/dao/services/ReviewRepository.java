package dao.services;

import entities.Review;

import java.util.List;

public interface ReviewRepository {

    void save( Review review);

    void deleteById( Long id );

    List<Review> getAllByUserId( Long userId);

    List<Review>  getAllByProductId (Long productId);
}
