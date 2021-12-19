package com.example.practica2.repository;

import com.example.practica2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p._name=?1")
    Product findProductByName(String name);
}