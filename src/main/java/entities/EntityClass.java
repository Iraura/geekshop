package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Column(name = "isDeleted")
    private boolean isDeleted = false;


    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntityClass{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
