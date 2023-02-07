package com.zaynsolution.ordermanagement.repository;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaynsolution.ordermanagement.entity.Complain;

/*  Respository interface is automatically implemented by JPA.  
    It automatically provides basic methods for get all complains or get individual complains.
    If you have any special requirement, like in our case we have a requirement to get complain 
    by customer id, than you can write a query for this and add a new method.
*/

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Integer>{


         @Query(
        value = "SELECT * FROM complain c WHERE c.customer_id = ?1", 
        nativeQuery = true)
        Collection<Complain> fetchComplainsByCustomerId(Integer customerId);
}
