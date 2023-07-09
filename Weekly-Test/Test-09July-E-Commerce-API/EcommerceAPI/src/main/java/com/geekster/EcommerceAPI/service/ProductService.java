package com.geekster.EcommerceAPI.service;

import com.geekster.EcommerceAPI.model.Category;
import com.geekster.EcommerceAPI.model.Product;
import com.geekster.EcommerceAPI.repository.IProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public String addProducts(Product product) {
        iProductRepo.save(product);
        return "Product Added Successfully";
    }

    public List<Product> getAllProductsByCategory(Category category) {
        // it's enum but Custom Query we are writing our self so, we will do first to this in string form
        return iProductRepo.getAllProductsByCategory(category.name());
    }

    @Transactional
    public String deleteById(Integer productId) {
        Integer deleteCount = iProductRepo.removeById(productId);
        if (deleteCount > 0) {
            return "Product, For ID : " + productId + " Successfully Deleted!!";
        }else {
            return "Product, For ID : " + productId + " Not Deleted Bcz this id does not exist in the Table";
        }
    }
}
