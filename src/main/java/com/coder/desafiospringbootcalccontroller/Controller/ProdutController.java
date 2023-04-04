package com.coder.desafiospringbootcalccontroller.Controller;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import com.coder.desafiospringbootcalccontroller.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
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

    //Pageable method PageRequest.of implementation
    @GetMapping(path = "/pages/{page}/{qtdItens}")
    public Iterable<Product> itensPerPage(@PathVariable int page, @PathVariable int qtdItens){
        if(qtdItens >= 5) qtdItens = 5;
        Pageable pagee = PageRequest.of(page, qtdItens);
        return productRepository.findAll(pagee);
    }

    //Creating new method in Repository with Springboot Methods Names Convention

    @GetMapping(path = "/nome/{prodName}")
    public Iterable<Product> findProductByName(@PathVariable String prodName){
        return productRepository.findByNameContaining(prodName);
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
        try{
        productRepository.deleteById(id);
        System.out.println("Produto de ID: " + id + " deletado com sucesso");
        }catch (IllegalArgumentException  e){
            System.out.println(e);
        }finally {
        System.out.println("Produto de ID: " + id + " deletado com sucesso");
        }
    }

}
