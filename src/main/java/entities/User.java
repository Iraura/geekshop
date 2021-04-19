package entities;

import liquibase.pro.packaged.S;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@MappedSuperclass
public class User extends EntityClass {

    public User() {

    }

    public User(String firstName, String lastName, String middleName, String password, String login , String phone){
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setPassword(password);
        setLogin(login);
        setPhone(phone);
    }

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "middleName")
    private String middleName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "phone")
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return String.format("%s %s %s", getLastName(), getFirstName(), getMiddleName());
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
