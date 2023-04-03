package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Product insertProduct(@RequestParam String name){
        Product product = new Product(name);
        productRepository.save(product);
        return product;
    }

//    @PutMapping
//    public @ResponseBody updateProduct(@RequestParam Long id, String name, double price, double disc){
//        Product productUpdate = productRepository.getReferenceById(id);
//
//        return productRepository.save(productUpdate(name, price, disc));
//    }

}
