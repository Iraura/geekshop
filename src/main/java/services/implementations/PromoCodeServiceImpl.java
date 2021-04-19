package services.implementations;

import dao.services.PromoCodeRepository;
import dto.PromoCodeRecord;
import entities.PromoCode;
import services.PromoCodeService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PromoCodeServiceImpl implements PromoCodeService {

    @Inject
    PromoCodeRepository promoCodeRepository;

    @Override
    public PromoCodeRecord createPromo(PromoCodeRecord record) {
        promoCodeRepository.save(new PromoCode(record));
        return record;
    }

    @Override
    public void deletePromo(PromoCodeRecord record) {
        promoCodeRepository.deleteByName(record.getName());
    }

    @Override
    public List<PromoCodeRecord> getAllPromoCodes() {
        return promoCodeRepository.findAll().stream().map(PromoCodeRecord::new).collect(Collectors.toList());
    }
}
