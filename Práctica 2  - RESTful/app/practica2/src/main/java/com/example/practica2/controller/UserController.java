package com.example.practica2.controller;

import com.example.practica2.model.Product;
import com.example.practica2.model.User;
import com.example.practica2.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
class UserController {

    private UserRepository _userRepository;

    public UserController(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return _userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = _userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not exists"));
        return user;
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name) {
        User user = _userRepository.findUserByName(name)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + name + " not exists"));
        return user;
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        User user = _userRepository.findUserByEmail(email)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + email + " not exists"));
        return user;
    }

    @PostMapping("")
    public void addUser(@RequestParam(value = "name")String name, @RequestParam(value = "email")String email,
    @RequestParam(value = "password")String password, @RequestParam(value = "admin", required = false)Boolean admin) {
        Boolean valueAdmin = false;
        if(admin != null)
            valueAdmin = admin;
        _userRepository.save(new User(name, email, password, valueAdmin));
    }

    @GetMapping("/products")
    public Set<Product> getUserByIdModel(HttpServletRequest request) {
        User user = _userRepository.findById((Integer) request.getSession().getAttribute("id"))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists"));
        return user.getProducts();
    }

    @PutMapping("/{id}")
    public void modifyUser(@PathVariable Integer id, @RequestParam(value = "name", required = false)String name,
    @RequestParam(value = "email", required = false)String email,
    @RequestParam(value = "password", required = false)String password, @RequestParam(value = "admin", required = false)Boolean admin) {
        User user = _userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not exists"));

        if(name != null) {
            user.setName(name);
        }
        if(email != null) {
            user.setEmail(email);
        }
        if(password != null) {
            user.setPassword(password);
        }
        if(admin != null)
            user.setAdmin(admin);
        _userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        User user = _userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not exists"));
        _userRepository.delete(user);
    }

    @GetMapping("/{id}/products")
    public Set<Product> getProductsByUser(@PathVariable Integer id) {
        User user = _userRepository.findById(id).get();
        return user.getProducts();
    }

    @DeleteMapping("/{id_user}/products/{id}")
    public void removeProductFromUser(@PathVariable User id_user, @PathVariable Product id) {
        User user = _userRepository.findById(id_user.getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + id + " not exists"));
        user.removeProduct(id);
        _userRepository.saveAndFlush(user);
    }

}