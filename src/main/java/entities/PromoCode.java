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

    private interface Columns {
        String NAME = "name";
        String DISCOUNT = "discount";
        String FROM_DATE = "fromDate";
        String TO_DATE = "toDate";
        String COUNT = "count";
        String IS_DELETED = "isDeleted";
    }

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
    @Column(name = Columns.NAME)
    private String name;

    @NotNull
    @Column(name = Columns.DISCOUNT)
    private int discount;

    @NotNull
    @Column(name = Columns.FROM_DATE)
    private Date fromDate;

    @NotNull
    @Column(name = Columns.TO_DATE)
    private Date toDate;

    @NotNull
    @Column(name = Columns.COUNT)
    private int count;

    @NotNull
    @Column(name = Columns.IS_DELETED)
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
