package com.examly.gst_billing_app.api;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,String> {

    public Product findByName(String name);

   // public Product saveById(Product product,String code);
}
