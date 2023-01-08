package com.becoder.Project.Managment.Backend.service;

import com.becoder.Project.Managment.Backend.model.Product;
import com.becoder.Project.Managment.Backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return this.productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
         Product product= this.productRepo.findById(id).get();
         if(product !=null){
             productRepo.delete(product);
             return "product deleted successfully";
         }
         return "Something wrong on server";
    }

    @Override
    public Product editProduct(Product p, Integer id) {
        Product oldProduct = this.productRepo.findById(id).get();
        oldProduct.setProductName(p.getProductName());
        oldProduct.setDescription(p.getDescription());
        oldProduct.setStatus(p.getStatus());
        oldProduct.setPrice(p.getPrice());
        return  productRepo.save(oldProduct);
    }
}
