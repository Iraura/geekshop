package entities;

import dto.CategoryRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = Category.TABLE_NAME)
public class Category extends EntityClass {

    public final static String TABLE_NAME = "Category";

    public Category() {

    }

    public Category(String name, String description) {
        setName(name);
        setDescription(description);
    }

    @NotNull
    @Column(name = "name")
    public String name;

    @NotNull
    @Column(name = "description")
    public String description;

    public Category(CategoryRecord record) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
