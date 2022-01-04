package com.example.practica2.controller;

import com.example.practica2.model.Product;
import com.example.practica2.model.User;
import com.example.practica2.repository.UserRepository;
import com.example.practica2.security.AuthResponse;
import com.example.practica2.security.JwtTokenUtil;
import com.example.practica2.security.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class EmailPassword {
    public String email;
    public String password;
}

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
class UserController {

    private UserRepository _userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    PasswordEncoder encode;

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

    @PostMapping("")
    public void addUser(@RequestParam(value = "name")String name, @RequestParam(value = "email")String email,
    @RequestParam(value = "password")String password, @RequestParam(value = "admin", required = false)Boolean admin) {
        Boolean valueAdmin = false;
        if(admin != null)
            valueAdmin = admin;
        _userRepository.save(new User(name, email, encode.encode(password), valueAdmin));
    }

    @GetMapping("/products")
    public Set<Product> getUserByIdModel(HttpServletRequest request) {
        User user = _userRepository.findById((Integer) request.getSession().getAttribute("id"))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists"));
        return user.getProducts();
    }

    @PostMapping(value = "login")
    public ResponseEntity<Object> login(@RequestParam(value = "email")String email, @RequestParam(value = "password")String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateJwtToken(authentication);
        UserManager userAuth = (UserManager) authentication.getPrincipal();
        List<String> roles = userAuth.getAuthorities().stream()
        .map(auth -> auth.getAuthority())
        .collect(Collectors.toList());

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setRoles(roles);
        return ResponseEntity.ok(authResponse);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> userSignup(@RequestParam(value = "name")String name,
    @RequestParam(value = "email")String email, @RequestParam(value = "password")String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(encode.encode(password));
        user.setName(name);
        user.setAdmin(false);
        _userRepository.save(user);
        return ResponseEntity.ok("User signed up successfully");
    }

    @GetMapping("logout")
    public void logout(HttpServletRequest session) {
        HttpSession httpSession = session.getSession(false);

        if (httpSession != null)
            httpSession.invalidate();
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