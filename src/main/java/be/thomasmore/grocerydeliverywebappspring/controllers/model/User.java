package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


// User.java
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", length = 50, nullable = false)
    private String username;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> authorities = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ShoppingCart cart;


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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}