package com.example.codingshuttle.jpaTutorial.jpatutorial;

import com.example.codingshuttle.jpaTutorial.jpatutorial.entities.ProductEntity;
import com.example.codingshuttle.jpaTutorial.jpatutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpatutorialApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        ProductEntity entity = ProductEntity.builder()
                .sku("acer123")
                .title("Acer Laptop with i5 9th Gen Processor")
                .price(BigDecimal.valueOf(1987.53))
                .quantity(5)
                .build();
        ProductEntity savedEntity = repository.save(entity);
        System.out.println(savedEntity);

        assert (savedEntity.getSku().equals("acer123"));
        assert (savedEntity.getTitle().equals("Acer Laptop with i5 9th Gen Processor"));
        assert (savedEntity.getPrice().compareTo(BigDecimal.valueOf(1987.53))) == 0;
        assert (savedEntity.getQuantity() == 5);
    }

}
