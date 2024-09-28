package com.spingdemo.ecommercecrud.repository;

import com.spingdemo.ecommercecrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {

}
