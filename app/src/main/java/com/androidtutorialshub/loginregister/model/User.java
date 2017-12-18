package com.androidtutorialshub.loginregister.model;

/**
 * Created by sowmyaram on 12/14/2017.
 */

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String user_pass;
    private String gender;
    private String usertype;
    private String confirmpass;
    private String hobbies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String getFirstName) {
        this.firstname = getFirstName;
    }

    public String getlastName() {
        return lastname;
    }

    public void setLastName(String getlastName) {
        this.lastname = getlastName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String getUserName) {
        this.username = getUserName;
    }


    public String getPassword() {
        return user_pass;
    }

    public void setPassword(String password) {
        this.user_pass = password;
    }


    public String getconfirmPassword() {
        return confirmpass;
    }

    public void setconfirmPassword(String password) {
        this.confirmpass = password;
    }
    //gendr

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

  //  usertype

    public String getUsertype() {
        return usertype;
    }

    public void setUsertpe(String usertype) {
        this.usertype = usertype;
    }

    //hobi

    public String gethobbies() {
        return hobbies;
    }

    public void sethobbies(String hobbies) {
        this.hobbies = hobbies;
    }




}
