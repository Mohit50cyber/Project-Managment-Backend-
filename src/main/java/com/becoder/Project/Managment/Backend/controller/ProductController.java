package com.becoder.Project.Managment.Backend.controller;

import com.becoder.Project.Managment.Backend.model.Product;
import com.becoder.Project.Managment.Backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> savePro(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }

    @PostMapping("/editProduct/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Integer id ,@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.editProduct(product,id));
    }
}
