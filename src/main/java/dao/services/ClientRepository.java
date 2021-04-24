package dao.services;


import entities.Client;

public interface ClientRepository {

    void save(Client clent);

    Client findByLoginAndPassword(String login, String password);

    void deleteById(Long id);

    Client findById(Long id);
}
