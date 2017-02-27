package com.ecommerce.rest.resources;

import com.ecommerce.core.entities.Client;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by gennt on 2/23/2017.
 */
public class ClientResource extends ResourceSupport{

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client toClient(){
        Client c = new Client();
        c.setUsername(this.username);
        c.setPassword(this.password);
        c.setName(this.name);
        c.setLastName(this.lastName);
        c.setAddress(this.address);
        c.setCity(this.city);
        c.setEmail(this.email);
        c.setCountry(this.country);

        return c;
    }
}
