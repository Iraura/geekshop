package dao.implementations;

import dao.services.PromoCodeRepository;
import entities.PromoCode;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PromoCodeRepositoryImpl implements PromoCodeRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(PromoCode promoCode) {
        entityManager.persist(promoCode);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        entityManager.createQuery("update PromoCode promocode set promocode.isDeleted = true where promoCode.name = :name ").
                setParameter("name", name);
    }

    @Override
    public List<PromoCode> findAll() {
        return entityManager.createQuery("select promocode from PromoCode promocode where promocode.isDeleted = false", PromoCode.class).
                getResultList();
    }

}
