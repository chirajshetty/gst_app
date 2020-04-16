package com.examly.gstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getListAllProducts(){
        return repo.findAll();
    }

    public void saveByProduct(Product p){
        repo.save(p);
    }

    public Product getById(int id){
        return repo.findById(id).get();
    }

    public Product getByName(String name){
        return repo.findByName(name);
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }


}
