package com.example.practica2.controller;

import com.example.practica2.model.Product;
import com.example.practica2.model.User;
import com.example.practica2.repository.ProductRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
class ProductController {

    private ProductRepository _productRepository;

    public ProductController(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @GetMapping("")
    public List<Product> getAllProducts(HttpSession session, Model model) {
        String userSession = (String) session.getAttribute("user");

        if (userSession == null)
            userSession = "";

        model.addAttribute("userSession", userSession);
        System.out.println("User: " + userSession);
        return _productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));
        return product;
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name){
        Product product = _productRepository.findProductByName(name)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + name + " not exists"));
        return product;
    }

    @PostMapping("")
    public void addProduct(@RequestParam(value = "name")String name, @RequestParam(value = "price")String price,
    @RequestParam(value = "description", required = false)String description) {
        _productRepository.save(new Product(name, Double.valueOf(price), description));
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public void addProductJSON(@RequestBody Product product) {
        _productRepository.save(product);
    }

    @PostMapping("/{id}")
    public void addProduct2User(@RequestParam(value = "user") User user, @PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));

        product.addUser(user);
        _productRepository.saveAndFlush(product);
    }

    @PostMapping(value = "/{id}/users/{user}", consumes = "application/json", produces = "application/json")
    public void addProduct2User2(@PathVariable User user, @PathVariable Integer id) {
        Product product = _productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));

        product.addUser(user);
        _productRepository.saveAndFlush(product);
    }

    @DeleteMapping("/{id}/users/{user}")
    public void removeProductFromUser(@PathVariable User user, @PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));

        product.removeUser(user);
        _productRepository.saveAndFlush(product);
    }

    @PutMapping("/{id}")
    public void modifyProduct(@PathVariable Integer id, @RequestParam(value = "name", required = false)String name,
    @RequestParam(value = "price", required = false)String price,
    @RequestParam(value = "description", required = false)String description,
    @RequestParam(value = "image", required = false)String image) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));

        if(name != null) {
            product.setName(name);
        }
        if(price != null) {
            product.setPrice(Double.valueOf(price));
        }
        if(description != null) {
            product.setDescription(description);
        }
        if(image != null) {
            product.setImage(image);
        }
        _productRepository.save(product);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public void modifyProductJSON(@RequestBody Product product, @PathVariable Integer id) {
        Product newProduct = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not exists"));

        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        newProduct.setImage(product.getImage());

        _productRepository.save(newProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        Product product = _productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));
        _productRepository.delete(product);
    }

}