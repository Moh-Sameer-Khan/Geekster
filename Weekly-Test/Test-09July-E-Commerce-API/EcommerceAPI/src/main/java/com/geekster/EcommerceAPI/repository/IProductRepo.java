package com.geekster.EcommerceAPI.repository;

import com.geekster.EcommerceAPI.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends CrudRepository<Product, Integer> {

}
