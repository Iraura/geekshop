package dto;

import entities.PromoCode;

import java.util.Date;

public class PromoCodeRecord extends EntityRecord {

    public PromoCodeRecord() {
    }

    public PromoCodeRecord(PromoCode code) {
        this.setName(code.getName());
        this.setCount(code.getCount());
        this.setDiscount(code.getDiscount());
        this.setFromDate(code.getFromDate());
        this.setToDate(code.getToDate());
    }

    private String name;

    private int discount;

    private Date fromDate;

    private Date toDate;

    private int count;

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

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
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
