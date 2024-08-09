package com.example.codingshuttle.jpaTutorial.jpatutorial.controllers;

import com.example.codingshuttle.jpaTutorial.jpatutorial.entities.ProductEntity;
import com.example.codingshuttle.jpaTutorial.jpatutorial.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
        return repository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price"));
    }

}
