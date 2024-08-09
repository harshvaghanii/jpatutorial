package com.example.codingshuttle.jpaTutorial.jpatutorial.repositories;

import com.example.codingshuttle.jpaTutorial.jpatutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
