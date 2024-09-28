package com.spingdemo.ecommercecrud.controller;

import com.spingdemo.ecommercecrud.model.Product;
import com.spingdemo.ecommercecrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productID){
        return new ResponseEntity<Product>(productService.getProductById(productID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id,
                                                   @RequestBody Product product){
        return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>(" Product Successfully.",HttpStatus.OK);
    }
}

