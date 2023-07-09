package com.geekster.EcommerceAPI.repository;

import com.geekster.EcommerceAPI.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends CrudRepository<Product, Integer> {

    @Query(value = "select * from Product where Product_Category = :category",nativeQuery = true)
    List<Product> getAllProductsByCategory(String category);

    @Modifying
    @Query(value = "delete from Product where product_id = :productId", nativeQuery = true)
    Integer removeById(Integer productId);
}
