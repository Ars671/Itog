package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Cotegory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotegoryRepository extends JpaRepository<Cotegory, Integer> {
    
//    List<Cotegory> findByName(String name);
    
}
