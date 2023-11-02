package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Cantract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantractRepository extends JpaRepository<Cantract, Integer> {
    
//    List<Cantract> findByName(String name);
    
}
