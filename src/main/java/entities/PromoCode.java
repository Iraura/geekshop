package entities;

import dto.PromoCodeRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = PromoCode.TABLE_NAME)
public class PromoCode {

    public final static String TABLE_NAME = "PromoCode";

    public PromoCode() {

    }

    public PromoCode(PromoCodeRecord record) {
        this(
                record.getName(),
                record.getDiscount(),
                record.getFromDate(),
                record.getToDate(),
                record.getCount()
        );
    }

    public PromoCode(String name, int discount, Date fromDate, Date toDate, int count) {
        setName(name);
        setDiscount(discount);
        setFromDate(fromDate);
        setToDate(toDate);
        setCount(count);
    }


    @Id
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "discount")
    private int discount;

    @NotNull
    @Column(name = "fromDate")
    private Date fromDate;

    @NotNull
    @Column(name = "toDate")
    private Date toDate;

    @NotNull
    @Column(name = "count")
    private int count;

    @NotNull
    @Column(name = "isDeleted")
    private boolean isDeleted;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                super.toString() +
                "name='" + name + '\'' +
                ", discount=" + discount +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", count=" + count +
                '}';
    }
}
