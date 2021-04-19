import entities.Admin;
import entities.Category;
import entities.Client;
import entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;

    public void saveClient(Client client){
        entityManager.persist(client);
    }

    public  void saveOrder( Order order){
        entityManager.merge(order);
    }

    public Client getClient () {
        return entityManager.find(Client.class, 1);
    }

}
