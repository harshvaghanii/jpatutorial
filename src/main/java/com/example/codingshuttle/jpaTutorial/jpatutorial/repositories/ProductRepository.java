package com.example.codingshuttle.jpaTutorial.jpatutorial.repositories;

import com.example.codingshuttle.jpaTutorial.jpatutorial.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    Page<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("select e.title, e.price from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

}
