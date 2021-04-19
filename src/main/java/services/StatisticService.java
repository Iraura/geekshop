package services;

import dto.ProductRecord;

import java.util.List;

public interface StatisticService {

    List<ProductRecord> getProductsOrderByPopularity();

    List<ProductRecord> getProductsOrderByTotalPrice();

}
