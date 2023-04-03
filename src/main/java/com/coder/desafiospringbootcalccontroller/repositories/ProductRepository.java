package com.coder.desafiospringbootcalccontroller.repositories;

import com.coder.desafiospringbootcalccontroller.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
