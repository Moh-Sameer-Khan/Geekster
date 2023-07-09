package com.geekster.EcommerceAPI.repository;

import com.geekster.EcommerceAPI.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address, Integer> {
}
