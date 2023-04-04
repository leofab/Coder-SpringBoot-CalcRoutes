package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProdutController {

    @Autowired
    ProductRepository productRepository;


//    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
//    public @ResponseBody Product insertProduct(@Valid @RequestParam String name){
//        Product product = new Product(name);
//        productRepository.save(product);
//        return product;
//    }

    @GetMapping
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        return products;
    }
    @GetMapping(path = "/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody Product insertProduct(@RequestParam String name){
        Product product = new Product(name);
        productRepository.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public @ResponseBody Product updateProduct(
            @Valid
            @RequestParam(name = "id") Long id,
            String name,
            double price,
            double disc)
    {
        Product productUpdate = productRepository.getReferenceById(id);
        productUpdate.setName(name);
        productUpdate.setPrice(price);
        productUpdate.setDisc(disc);
        return productRepository.save(productUpdate);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}
