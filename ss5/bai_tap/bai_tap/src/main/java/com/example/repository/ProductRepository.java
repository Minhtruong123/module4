package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> listAllProducts(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> productList = entityManager.createQuery("from Product where name like concat('%',:name,'%') ").setParameter("name", search).getResultList();
        return productList;
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    @Transactional
    public void editProduct(Product product) {
        Product product1 = entityManager.find(Product.class, product.getId());
        product1.setName(product.getName());
        product1.setDescribe(product.getDescribe());
        product1.setBrand(product.getBrand());
        entityManager.merge(product1);
    }


}
