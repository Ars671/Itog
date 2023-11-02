package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
//    List<Supplier> findByName(String name);
    
}
