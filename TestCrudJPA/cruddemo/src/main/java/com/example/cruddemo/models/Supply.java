package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "supply")

public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Number supply is required")

    private String numbersupply;

    @NotNull(message = "Quanti is required")

    private int quanti;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Cantract cantract;


    public Supply() {}

    public Supply(String numbersupply, int quanti) {
        this.numbersupply = numbersupply;
        this.quanti = quanti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumbersupply() {
        return numbersupply;
    }

    public void setNumbersupply(String numbersupply) {
        this.numbersupply = numbersupply;
    }

    public int getQuanti() {
        return quanti;
    }

    public void setQuanti(int quanti) {
        this.quanti = quanti;
    }

    public Cantract getCantract() {
        return cantract;
    }

    public void setCantract(Cantract cantract) {
        this.cantract = cantract;
    }
}
