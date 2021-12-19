package com.example.practica2.controller;

import com.example.practica2.model.Product;
import com.example.practica2.repository.ProductRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {

    private ProductRepository _productRepository;

    public ProductController(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return _productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not exists"));
        return product;
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        Product product = _productRepository.findProductByName(name);
        return product;
    }


    @PostMapping("")
    public void addProduct(@RequestParam(value = "name")String name, @RequestParam(value = "price")String price,
    @RequestParam(value = "description", required = false)String description) {
        _productRepository.save(new Product(name, Double.valueOf(price), description));
    }

    @PutMapping("/{id}")
    public void modifyProduct(@PathVariable Integer id, @RequestParam(value = "name", required = false)String name,
    @RequestParam(value = "price", required = false)String price,
    @RequestParam(value = "description", required = false)String description) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not exists"));

        if(name != null) {
            product.setName(name);
        }
        if(price != null) {
            product.setPrice(Double.valueOf(price));
        }
        if(description != null) {
            product.setDescription(description);
        }
        _productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product " + id + " not exists"));
        _productRepository.delete(product);
    }

}