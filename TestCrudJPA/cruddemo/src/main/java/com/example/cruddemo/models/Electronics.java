package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "electronics")

public class Electronics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String electronicsname;

    @NotNull(message = "Quantity is required")

    private int quantity;

    @NotBlank(message = "Article is required")

    private String article;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Warehouse warehouse;
    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Cotegory cotegory;

    public Electronics() {}

    public Electronics(String electronicsname, int quantity, String article) {
        this.electronicsname = electronicsname;
        this.quantity = quantity;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectronicsname() {
        return electronicsname;
    }

    public void setElectronicsname(String electronicsname) {
        this.electronicsname = electronicsname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Cotegory getCotegory() {
        return cotegory;
    }

    public void setCotegory(Cotegory cotegory) {
        this.cotegory = cotegory;
    }
}
