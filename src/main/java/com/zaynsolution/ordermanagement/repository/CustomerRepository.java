package com.zaynsolution.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
import com.zaynsolution.ordermanagement.entity.Customer;

/*  Respository interface is automatically implemented by JPA.  
    It automatically provides basic methods for get all customers or get individual customer.
*/

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  
}