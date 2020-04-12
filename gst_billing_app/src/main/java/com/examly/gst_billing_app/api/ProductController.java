package com.examly.gst_billing_app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    //getALL
    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> arr = new ArrayList<Product>();
        productRepo.findAll().forEach(arr::add);
        return arr;
    }

    //getByID
    @GetMapping("/product/id/{code}")
    public Product getProduct(@PathVariable("code") String code){
        return productRepo.findById(code).get();
    }

    //getByName
    @GetMapping("/product/name/{code}")
    public Product getProductByName(@PathVariable("code") String name){
        return productRepo.findByName(name);
    }

    //deleteProductByID
    @DeleteMapping("/product/{code}")
    public void newProduct(@PathVariable String code ){
         productRepo.deleteById(code);
    }

    //PostProduct
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    //updateProduct
    @PutMapping("/product/{code}")
    public Product newProduct(@RequestBody Product product,@PathVariable String code ){
        return productRepo.save(product);
    }


}
