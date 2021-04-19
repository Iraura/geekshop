package services;

import dto.CategoryRecord;
import dto.ProductRecord;
import dto.SectionRecord;

import java.util.List;

public interface ProductService {

    ProductRecord createProduct( ProductRecord record);

    void deleteProduct( ProductRecord record);

    List<ProductRecord> getAvailable();

}
