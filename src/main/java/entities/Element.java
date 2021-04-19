package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = Element.TABLE_NAME)
public class Element extends EntityClass implements Serializable {

    public final static String TABLE_NAME = "Element";

    public Element() {

    }

    public Element( String code, Order order , Product product){
        setCode(code);
        setOrder(order);
        setProduct(product);
    }

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @OneToOne
    private Order order;

    @NotNull
    @OneToOne
    private Product product;

    @NotNull
    @Column(name = "count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order orderId) {
        this.order = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Element{" +
                super.toString() +
                "code='" + code + '\'' +
                ", order=" + order +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
