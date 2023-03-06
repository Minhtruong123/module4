package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> listAllProducts(String search) {
        return iProductRepository.listAllProducts(search);
    }

    @Override
    public Product findProductById(int id) {
        return iProductRepository.findProductById(id);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public void editProduct(Product product) {
        iProductRepository.editProduct(product);
    }
}
