package com.coder.desafiospringbootcalccontroller.repositories;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Iterable<Product> findByNameContainingIgnoreCase(String prodName);

    // Convenções SpringBoot {} -> nome do atributo

    //findBy{Name}Containing
    //findBy{Name}IsContaining
    //findBy{Name}Contains
    //
    //findBy{Name}StartsWith
    //findBy{Name}EndsWith
    //
    //findBy{Name}NotContaning

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public Iterable<Product> searchByNameLike(@Param("name") String name);
}
