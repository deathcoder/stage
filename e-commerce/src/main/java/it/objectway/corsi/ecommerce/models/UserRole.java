package it.objectway.corsi.ecommerce.models;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class UserRole{

    private Integer userRoleId;
    private User user;
    private StringBuilder role;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role.toString();
    }

    public void setRole(String role) {
        this.role = new StringBuilder(role);
    }
}
