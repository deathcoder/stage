package it.objectway.corsi.hibtest.models;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public class Account {
    private long id;
    private StringBuilder username;
    private StringBuilder password;
    private Profile profile;

    public Account() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
