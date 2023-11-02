package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.sql.Date;

@Entity
@Table(name = "cantract")

public class Cantract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String numbercantract;

    private Date dateformation;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Warehouse warehouse;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Supplier supplier;




    public Cantract() {}

    public Cantract(String numbercantract, Date dateformation) {
        this.numbercantract = numbercantract;
        this.dateformation = dateformation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumbercantract() {
        return numbercantract;
    }

    public void setNumbercantract(String numbercantract) {
        this.numbercantract = numbercantract;
    }

    public Date getDateformation() {
        return dateformation;
    }

    public void setDateformation(Date dateformation) {
        this.dateformation = dateformation;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}
