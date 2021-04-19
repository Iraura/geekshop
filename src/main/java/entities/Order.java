package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = Order.TABLE_NAME)
public class Order extends EntityClass {

    public final static String TABLE_NAME = "Orders";

    public Order () {

    }

    public Order( Client client, String status, int cost, Date deliveryDate, Date orderDate){
        setClient(client);
        setStatus(status);
        setCost(cost);
        setDeliveryDate(deliveryDate);
        setOrderDate(orderDate);
    }

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_ID")
    private Client client;

    @NotNull
    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "cost")
    private int cost;

    @NotNull
    @Column(name = "orderDate")
    private Date orderDate;

    @NotNull
    @Column(name = "deliveryDate")
    private Date deliveryDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client user) {
        this.client = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                super.toString() +
                "client=" + client +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
