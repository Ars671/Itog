package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "warehouse")

public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")

    private String warehousename;

    @NotBlank(message = "Address is required")

    private String address;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.EAGER)
    private Collection<Electronics> tenants;


    public Warehouse() {}

    public Warehouse(String warehousename, String address) {
        this.warehousename = warehousename;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Electronics> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Electronics> tenants) {
        this.tenants = tenants;
    }

}
