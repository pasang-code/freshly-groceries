package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import java.io.Serializable;
import java.util.Objects;

public class AuthorityId implements Serializable {
    private String username;    // field names must match
    private String authority;   // the @Id fields in Authority

    public AuthorityId() {
    }

    public AuthorityId(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorityId)) return false;
        AuthorityId that = (AuthorityId) o;
        return Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }
}