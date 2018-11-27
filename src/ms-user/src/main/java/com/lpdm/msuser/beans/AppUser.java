package com.lpdm.msuser.beans;

import com.lpdm.msuser.Access;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private Enum<Access> role;

    private String name;
    private String firstName;

    private Address address;

    public AppUser() {
    }

    public AppUser(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }

    public AppUser(@NotNull String email, @NotNull String password, Enum<Access> role, String name, String firstName, Address address) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.firstName = firstName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum<Access> getRole() {
        return role;
    }

    public void setRole(Enum<Access> role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address=" + address +
                '}';
    }
}
