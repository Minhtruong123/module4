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
        List<Product> products = null;
        if (search == null){
            search="";
        }
        products = entityManager.createQuery("from Product where name like concat('%',:name,'%') ").setParameter("name",search).getResultList();
        return products;
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

    @Override
    @Transactional
    public void deleteProduct(int id) {
        entityManager.remove(entityManager.find(Product.class,id));
    }
    @Transactional
    @Override
    public void editProduct(Product product) {
        Product product1 = findProductById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescribe(product.getDescribe());
        product1.setProducer(product.getProducer());
        entityManager.merge(product1);
    }
}
