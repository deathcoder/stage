package it.objectway.corsi.ecommerce.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class User {
    private StringBuilder username;
    private StringBuilder password;
    private boolean enabled;
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    public String getUsername() {
        return username.toString();
    }

    public void setUsername(String username) {
        this.username = new StringBuilder(username);
    }

    public String getPassword() {
        return password.toString();
    }

    public void setPassword(String password) {
        this.password = new StringBuilder(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
