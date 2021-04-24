package entities;

import dto.ClientRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = Client.TABLE_NAME)
public class Client extends User {

    public final static String TABLE_NAME = "Client";

    public Client() {

    }

    public Client(
            String firstName, String lastName, String middleName, String password, String login,
            String phone, Date birthDay, String email, String address
    ) {
        super(firstName, lastName, middleName, password, login, phone);
        setBirthDay(birthDay);
        setEmail(email);
        setAddress(address);
    }

    public Client(ClientRecord record) {
        this(
                record.getFirstName(),
                record.getLastName(),
                record.getMiddleName(),
                record.getPassword(),
                record.getLogin(),
                record.getPhone(),
                record.getBirthDay(),
                record.getEmail(),
                record.getAddress()
        );
    }

    @NotNull
    @Column(name = "birthDay")
    private Date birthDay;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                "birthDay=" + birthDay +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
