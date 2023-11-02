package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "cotegory")

public class Cotegory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String cotegoryname;

    @OneToMany(mappedBy = "cotegory",fetch = FetchType.EAGER)
    private Collection<Electronics> tenants;

    public Cotegory() {}

    public Cotegory(String cotegoryname) {
        this.cotegoryname = cotegoryname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCotegoryname() {
        return cotegoryname;
    }

    public void setCotegoryname(String cotegoryname) {
        this.cotegoryname = cotegoryname;
    }

    public Collection<Electronics> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Electronics> tenants) {
        this.tenants = tenants;
    }
}
