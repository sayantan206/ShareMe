package com.demo.entity;

import com.demo.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class NewUser {

    @NotNull(message = "Username cannot be empty")
    @Size(min = 1, message = "Username cannot be empty")
    private String userName;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 1, message = "Password cannot be empty")
    private String password;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 1, message = "Password cannot be empty")
    private String matchingPassword;

    @Email(message = "Invalid email address")
    @NotNull(message = "Invalid email address")
    @Size(min = 1, message = "Invalid email address")
    private String email;

    public NewUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
