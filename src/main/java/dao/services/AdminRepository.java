package dao.services;
import entities.Admin;

public interface AdminRepository {

    void save( Admin admin);

    Admin findByLoginAndPassword ( String login, String password);

    void deleteById( Long id);

    Admin findById( Long id);

}
