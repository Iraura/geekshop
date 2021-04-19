package services;

import dto.PromoCodeRecord;
import entities.PromoCode;

import java.util.List;

public interface PromoCodeService {
    PromoCodeRecord createPromo ( PromoCodeRecord record);

    List<PromoCodeRecord> getAllPromoCodes ();

    void deletePromo (PromoCodeRecord record);
}
