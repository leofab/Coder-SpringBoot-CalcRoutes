package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutController {

    ProductRepository productRepository;

//    @GetMapping
//    public List<Product> findAll(){
//        return productRepository.findAll();
//    }

    @PostMapping
    public Product insertProduct(@RequestParam String name){
        Product product = new Product(name);
        return product;
    }

}
