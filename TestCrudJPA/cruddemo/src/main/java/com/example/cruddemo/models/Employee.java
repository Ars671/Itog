package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String firstname;

    @NotBlank(message = "Name is required")

    private String secondname;

    @NotBlank(message = "Article is required")

    private String middlename;

    @NotBlank(message = "Article is required")

    private String login;

    @NotBlank(message = "Article is required")

    private String passwordemp;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Warehouse warehouse;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Post post;

    public Employee() {}

    public Employee(String firstname, String secondname, String middlename, String login, String passwordemp) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.middlename = middlename;
        this.login = login;
        this.passwordemp = passwordemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordemp() {
        return passwordemp;
    }

    public void setPasswordemp(String passwordemp) {
        this.passwordemp = passwordemp;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
