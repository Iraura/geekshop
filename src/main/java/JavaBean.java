import entities.*;
import liquibase.pro.packaged.S;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;


    public void saveOrder(Order order) {
        entityManager.merge(order);
    }

    public void persistOrder(Order order) {
        entityManager.persist(order);
    }

    public void saveClient(Client client) {
        entityManager.merge(client);
    }

    public void deleteClient(Client client){
      entityManager.remove(entityManager.find(Client.class, client.getId()));
    }

    public void deleteOrder(Order order){
        entityManager.remove(entityManager.find(Order.class, order.getId()));
    }

    public void persistClient(Client client) {
        entityManager.persist(client);
    }

    public void saveAdmin(Admin admin) {
        entityManager.merge(admin);
    }

    public void persistAdmin(Admin admin) {
        entityManager.persist(admin);
    }

    public void saveElement(Element element) {
        entityManager.merge(element);
    }

    public void persistElement(Element element) {
        entityManager.persist(element);
    }

    public void saveProduct(Product product) {
        entityManager.merge(product);
    }

    public void persistProduct(Product product) {
        entityManager.persist(product);
    }

    public void savePromoCode(PromoCode promoCode) {
        entityManager.merge(promoCode);
    }

    public void persistPromoCode(PromoCode promoCode) {
        entityManager.persist(promoCode);
    }

    public void saveReview(Review review) {
        entityManager.merge(review);
    }

    public void persistReview(Review review) {
        entityManager.persist(review);
    }

    public void saveSection(Section section) {
        entityManager.merge(section);
    }

    public void persistSection(Section section) {
        entityManager.persist(section);
    }

    public void saveCategory(Category category) {
        entityManager.merge(category);
    }

    public void persistCategory(Category category) {
        entityManager.persist(category);
    }

    public Client getClient() {
        return entityManager.find(Client.class, 1);
    }

}
