package dao.implementations;

import dao.services.ClientRepository;
import entities.Client;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class ClientRepositoryImpl implements ClientRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Client client) {
        entityManager.persist(client);
    }

    @Override
    @Transactional
    public void deleteById( Long adminId){
        entityManager.createQuery(
                "update Client client set client.isDeleted = true where client.id = :id")
                .setParameter("id", adminId);
    }

    @Override
    public Client findById(Long id){
        return entityManager.find(Client.class, id);
    }

    @Override
    public Client findByLoginAndPassword( String login, String password){
        return entityManager.createQuery(
                "select client from Client client where client.isDeleted = false and client.login = :login and client.password = :password ",
                Client.class).setParameter("login", login).setParameter("password", password).getResultList().get(0);
    }
}
