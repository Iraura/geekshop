package services;


import dto.SectionRecord;

import java.util.List;

public interface SectionService {

    SectionRecord createSection(SectionRecord sectionRecord);

    List<SectionRecord> getSections();

    void deleteSection(SectionRecord record);

}
