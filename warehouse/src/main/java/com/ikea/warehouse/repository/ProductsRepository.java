package com.ikea.warehouse.repository;

import com.ikea.warehouse.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
