package com.example.practica2.model;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer _id;

    @Column(name = "name")
    private String _name;

    @Column(name = "price")
    private Double _price;

    @Column(name = "description")
    private String _description;

    public Product() {
    }

    public Product(String name, Double price, String description) {
        _name = name;
        _price = price;
        _description = description;
    }

    public Integer getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double _price) {
        this._price = _price;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

}