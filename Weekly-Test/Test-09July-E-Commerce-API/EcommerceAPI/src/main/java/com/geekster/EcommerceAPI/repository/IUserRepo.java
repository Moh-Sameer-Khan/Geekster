package com.geekster.EcommerceAPI.repository;

import com.geekster.EcommerceAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User, Integer> {
}
