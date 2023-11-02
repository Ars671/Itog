package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    
//    List<Warehouse> findByName(String name);
    
}
