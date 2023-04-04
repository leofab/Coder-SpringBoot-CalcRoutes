package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        return products;
    }

    @PostMapping
    public @ResponseBody Product insertProduct(@RequestParam String name){
        Product product = new Product(name);
        productRepository.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public @ResponseBody Product updateProduct(@Valid @RequestParam(name = "id") Long id, String name, double price, double disc){
        Product productUpdate = productRepository.getReferenceById(id);
        productUpdate.setName(name);
        productUpdate.setPrice(price);
        productUpdate.setDisc(disc);
        return productRepository.save(productUpdate);
    }

}
