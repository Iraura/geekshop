package dao.implementations;

import dao.services.SectionRepository;
import entities.Section;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class SectionRepositoryImpl implements SectionRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Section section) {
        entityManager.persist(section);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        entityManager.createQuery("update  Section section set section.isDeleted = true where section.id =:id").
                setParameter("id", id);
    }

    @Override
    public List<Section> findAll() {
        return entityManager.createQuery("select section from Section section where section.isDeleted = false", Section.class).
                getResultList();
    }

    public List<Section> findByName(String name) {
        return entityManager.createQuery(
                "select section from Section section where section.isDeleted = false and section.name = :name",
                Section.class).setParameter("name", name).getResultList();
    }

    @Override
    public Section findById(Long id) {
        return entityManager.find(Section.class, id);
    }
}
