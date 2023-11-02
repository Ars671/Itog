package com.example.cruddemo.repositories;

import com.example.cruddemo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
    List<Post> findByPostname(String postname);
    
}
