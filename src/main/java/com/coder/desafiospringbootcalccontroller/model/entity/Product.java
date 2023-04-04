package com.coder.desafiospringbootcalccontroller.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    public Product(String name){
        this.name = name;
    }
    public Product(String name, Double price, Double disc ){
        this.name = name;
        this.price = price;
        this.disc = disc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Column
    String name;

    @Min(0)
    @Column
    Double price;

    @Min(0)
    @Max(1)
    @Column
    Double disc;
}
