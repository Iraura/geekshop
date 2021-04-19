package services.implementations;

import dao.services.ElementRepository;
import dao.services.ProductRepository;
import dto.ProductRecord;
import entities.Element;
import entities.Product;
import services.StatisticService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticServiceImpl implements StatisticService {

    @Inject
    ElementRepository elementRepository;

    @Inject
    ProductRepository productRepository;

    @Override
    public List<ProductRecord> getProductsOrderByPopularity() {
        List<Product> products = productRepository.getAvailable();
        List<ProductRecord> result = new ArrayList<ProductRecord>();
        for( int i =0 ; i <products.size() ; i++) {
            Product current = products.get(i);
            List<Element> elements = elementRepository.getAllByProductIdOrderByCount(current.getId());
            long totalCount = 0 ;
            long totalPrice = 0 ;
            for(Element element : elements){
                totalCount+=element.getCount();
            }
            totalPrice +=  totalCount*current.getPrice();
            ProductRecord productRecord = new ProductRecord(current);
            productRecord.setTotalCount(totalCount);
            productRecord.setTotalPrice(totalPrice);
            result.add(productRecord);
        }
        return  result;
    }

    @Override
    public List<ProductRecord> getProductsOrderByTotalPrice() {
        List<Product> products = productRepository.getAvailable();
        List<ProductRecord> result = new ArrayList<ProductRecord>();
        for( int i =0 ; i <products.size() ; i++) {
            Product current = products.get(i);
            List<Element> elements = elementRepository.getAllByProductId(current.getId());
            long totalCount = 0 ;
            long totalPrice = 0 ;
            for(Element element : elements){
                totalCount+=element.getCount();
            }
            totalPrice +=  totalCount*current.getPrice();
            ProductRecord productRecord = new ProductRecord(current);
            productRecord.setTotalCount(totalCount);
            productRecord.setTotalPrice(totalPrice);
            result.add(productRecord);
        }
        result = result.stream().sorted(Comparator.comparing(ProductRecord::getTotalPrice)).collect(Collectors.toList());
        return  result;
    }

}
