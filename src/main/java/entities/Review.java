package entities;

import liquibase.pro.packaged.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Review.TABLE_NAME)
public class Review extends EntityClass {

    public final static String TABLE_NAME = "Review";

    public Review() {

    }

    public Review(Client client, Product product, String content){
        setClient(client);
        setProduct(product);
        setContent(content);
    }

    @NotNull
    @OneToOne
    private Client client = new Client();

    @NotNull
    @OneToOne
    private Product product = new Product();

    @NotNull
    @Column(name = "content")
    private String content;

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientId) {
        this.client = clientId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product orderId) {
        this.product = orderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                super.toString() +
                "client=" + client +
                ", product=" + product +
                ", content='" + content + '\'' +
                '}';
    }
}
