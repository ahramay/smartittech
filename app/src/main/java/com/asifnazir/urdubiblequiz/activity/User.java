package com.asifnazir.urdubiblequiz.activity;

public class User {
    private String name, email, pass ,profile, userId , referCode;

    private long coins;

    public User() {}
    // Singup Constructor
    public User(String name, String email, String pass , String referCode) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.referCode = referCode;
    }

    public User(String name, String email, String pass, String profile, String userId, String referCode) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.profile = profile;
        this.userId = userId;
        this.referCode = referCode;
    }


    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}