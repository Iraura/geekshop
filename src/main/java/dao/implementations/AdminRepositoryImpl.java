package dao.implementations;

import entities.Admin;
import dao.services.AdminRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class AdminRepositoryImpl implements AdminRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Admin admin) {
        entityManager.persist(admin);
    }

    @Override
    @Transactional
    public void deleteById(Long adminId) {
        entityManager.createQuery(
                "update Admin admin set admin.isDeleted = true where admin.id = :id")
                .setParameter("id", adminId);
    }

    @Override
    public Admin findById(Long id) {
        return entityManager.find(Admin.class, id);
    }

    @Override
    public Admin findByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select admin from Admin admin where admin.isDeleted = false and admin.login = :login and admin.password = :password ",
                Admin.class).setParameter("login", login).setParameter("password", password).getResultList().get(0);
    }
}
