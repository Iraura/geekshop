package entities;

import dto.ProductRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product extends EntityClass {

    public final static String TABLE_NAME = "Product";

    public Product() {

    }

    public Product( String name, String description, int price, int count, Category category, Section section, String picture){
        setName(name);
        setDescription(description);
        setPrice(price);
        setCount(count);
        setCategory(category);
        setSection(section);
        setPicture(picture);
    }

    public Product (ProductRecord record, Section section, Category category){
        this(
                record.getName(),
                record.getDescription(),
                record.getPrice(),
                record.getCount(),
                category,
                section,
                record.getPicture()
        );
    }

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private int price;

    @NotNull
    @Column(name = "count")
    private int count;

    @NotNull
    @OneToOne
    private Category category;

    @NotNull
    @OneToOne
    private Section section;

    @NotNull
    @Column(name = "picture")
    private String picture;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section sectionId) {
        this.section = sectionId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", category=" + category +
                ", section=" + section +
                ", picture='" + picture + '\'' +
                '}';
    }
}
