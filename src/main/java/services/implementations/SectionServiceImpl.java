package services.implementations;

import dao.services.SectionRepository;
import dto.SectionRecord;
import entities.Section;
import services.SectionService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class SectionServiceImpl implements SectionService {

    @Inject
    SectionRepository sectionRepository;

    @Override
    public List<SectionRecord> getSections() {
        return sectionRepository.findAll().stream().map(SectionRecord::new).collect(Collectors.toList());
    }

    @Override
    public SectionRecord createSection(SectionRecord sectionRecord) {
        sectionRepository.save(new Section(sectionRecord));
        return  sectionRecord;
    }

    @Override
    public void deleteSection(SectionRecord record) {
        sectionRepository.deleteById(record.getId());
    }
}
