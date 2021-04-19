package services.implementations;

import dao.services.CategoryRepository;
import dao.services.ProductRepository;
import dao.services.SectionRepository;
import dto.ProductRecord;
import entities.Category;
import entities.Product;
import entities.Section;
import services.ProductService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    @Inject
    ProductRepository productRepository;

    @Inject
    SectionRepository sectionRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Override
    public ProductRecord createProduct(ProductRecord record) {
        Section section = sectionRepository.findById( record.getSectionId());
        Category category = categoryRepository.findById(record.getCategoryId());
        productRepository.save(new Product(record, section, category));
        return record;
    }

    @Override
    public void deleteProduct(ProductRecord record) {
        productRepository.deleteById(record.getId());
    }

    @Override
    public List<ProductRecord> getAvailable() {
        return productRepository.getAvailable().stream().map(ProductRecord::new).collect(Collectors.toList());
    }

}
