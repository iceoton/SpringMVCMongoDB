package com.itboxlab.mvcmongodb.medel;

import org.springframework.data.annotation.Id;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private String email;
    private String salt;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.salt = "";
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
