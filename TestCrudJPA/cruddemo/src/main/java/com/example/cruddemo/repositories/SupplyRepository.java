package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
    
//    List<Supply> findByName(String name);
    
}
