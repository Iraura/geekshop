package dao.services;

import entities.PromoCode;

import java.util.List;

public interface PromoCodeRepository {
    void save(PromoCode promoCode);

    void deleteByName( String name);

    List<PromoCode> findAll();

}
