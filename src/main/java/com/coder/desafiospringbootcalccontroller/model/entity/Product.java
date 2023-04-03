package com.coder.desafiospringbootcalccontroller.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    public Product(String name){
        this.name = name;
    }
    public Product(String name, double price, double disc ){
        this.name = name;
        this.price = price;
        this.disc = disc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column
    double price;

    @Column
    double disc;
}
