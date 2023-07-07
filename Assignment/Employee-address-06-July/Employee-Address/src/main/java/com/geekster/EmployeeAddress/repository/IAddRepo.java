package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.model.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRepo extends CrudRepository<Address, Long> {
    @Modifying
    @Query(value = "update Address set city = :newCity where add_Id = :addId", nativeQuery = true)
    Integer updateAddressCityById(Long addId, String newCity);

    @Modifying
    @Query(value = "delete from Address where add_Id = :addId and state = :state", nativeQuery = true)
    Integer deleteAddressByIdAndState(Long addId, String state);
}
