package dao.services;



import entities.Section;

import java.util.List;

public interface SectionRepository {

    void save (Section section);

    void deleteById(Integer id);

    List<Section> findAll();

    List<Section> findByName(String name);

    Section findById( Long id);


}
