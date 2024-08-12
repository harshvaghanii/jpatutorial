package com.example.codingshuttle.jpaTutorial.jpatutorial.controllers;

import com.example.codingshuttle.jpaTutorial.jpatutorial.entities.ProductEntity;
import com.example.codingshuttle.jpaTutorial.jpatutorial.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductRepository repository;

    private final int PAGE_SIZE = 5;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(defaultValue = "0") Integer pageNumber
    ) {
        Sort.Direction sortOrder = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortOrder, sortBy, "price"));
        return repository.findByTitleContainingIgnoreCase(title, pageable).getContent();
    }

}
