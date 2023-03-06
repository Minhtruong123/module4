package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> listAllProducts(String search);
    Product findProductById(int id);


    void createProduct(Product product);

    void deleteProduct(int id);

    void editProduct(Product product);

}
