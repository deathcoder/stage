package it.objectway.corsi.hibtest.models;

import java.util.Date;

/**
 * Created by stageusr2015 on 04/06/2015.
 */
public class Profile {
    private long account;
    private StringBuilder name;
    private StringBuilder lastname;
    private Date birth;
    private Account accountObj;

    public Profile() { }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(String name) {
        this.name = new StringBuilder(name);
    }

    public String getLastname() {
        return lastname.toString();
    }

    public void setLastname(String lastname) {
        this.lastname = new StringBuilder(lastname);
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Account getAccountObj() {
        return accountObj;
    }

    public void setAccountObj(Account accountObj) {
        this.accountObj = accountObj;
    }
}
