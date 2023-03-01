package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", "1000", "fantastic", "PHP"));
        productList.add(new Product(2, "Phone", "2000", "fantastic", "Apple"));
        productList.add(new Product(3, "Desktop", "3000", "beautiful", "Asus"));
    }

    @Override
    public List<Product> listAllProducts(String search) {
        List<Product> products = new ArrayList<>();
        if (search == null){
            return productList;
        }else {
            for (Product product: productList){
                if (product.getName().contains(search))
                    products.add(product);
            }
        } return products;
    }

    @Override
    public Product findProductById(int id) {
        for (Product product: productList) {
            if (product.getId()==id)
                return product;
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = this.findProductById(id);
        if (product != null)
        productList.remove(product);
    }

    @Override
    public void editProduct(Product product) {
        for (Product product1 : productList){
            if (product1.getId()== product.getId()){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getPrice());
                product1.setProducer(product.getProducer());
            }
        }
    }
}
