package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/products")
public class ProdutController {

    ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product insertProduct(@RequestParam Long id, String name){
        Product product = new Product(id, name);
        return product;
    }

}
