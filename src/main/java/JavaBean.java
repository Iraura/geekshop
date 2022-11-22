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
        entityManager.flush();
    }

    public void persistOrder(Order order) {
        entityManager.persist(order);
        entityManager.flush();
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
        entityManager.flush();
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

    public Client getClient(Integer id) {
        return entityManager.find(Client.class, id);
    }

    public List<Category> getCategories(){
        return entityManager.createQuery("select category from Category category where category.isDeleted = false", Category.class).
                getResultList();
    }

    public List<Section> getSections () {
        return entityManager.createQuery("select section from Section section where section.isDeleted = false", Section.class).
                getResultList();
    }

    public List<Product> getProducts(){
        return entityManager.createQuery(" select product from Product product where  product.count > 0 and product.isDeleted = false", Product.class).getResultList();
    }

    public List<Client> findClientByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select client from Client client where client.isDeleted = false and client.login = :login and client.password = :password ",
                Client.class).setParameter("login", login).setParameter("password", password).getResultList();
    }

    public List<Order> getOrdersForAdmin(){
        return entityManager.createQuery(
                "select order from Order order where   order.isDeleted = false ", Order.class).getResultList();
    }

    public List<Order> getOrdersForClient(Integer clientId){
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", clientId).getResultList();
    }

    public List<Order> getOrdersByUserId(Integer userId){
        return entityManager.createQuery(
                "select order from Order order where order.client.id = :id and order.isDeleted = false ",
                Order.class).setParameter("id", userId).getResultList();
    }

    public Product findProductById(Integer productId) {
        return entityManager.find(Product.class, productId);
    }

    public Order findOrderById(Integer orderId){
        return entityManager.find(Order.class, orderId);
    }

    public List<Admin> findAdminByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select admin from Admin admin where admin.isDeleted = false and admin.login = :login and admin.password = :password ",
                Admin.class).setParameter("login", login).setParameter("password", password).getResultList();
    }

    public List<Object[]> statisticQueryByProductCount(){
        return  entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();

    }

    public List<Object[]> statisticQueryByProductPrice(){
        return  entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou*product.price \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();
    }

}
