package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "supplier")

public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String suppliername;

    @NotBlank(message = "Phone number is required")

    private String phonenumber;

    @NotNull(message = "Inn is required")

    private int inn;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
    private Collection<Cantract> tenants;

    public Supplier() {}

    public Supplier(String suppliername, String phonenumber, int inn) {
        this.suppliername = suppliername;
        this.phonenumber = phonenumber;
        this.inn = inn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public Collection<Cantract> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Cantract> tenants) {
        this.tenants = tenants;
    }
}
