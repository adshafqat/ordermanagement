package com.zaynsolution.ordermanagement.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
  
import com.zaynsolution.ordermanagement.entity.Order;

/*  Respository interface is automatically implemented by JPA.  
    It automatically provides basic methods for get all orders or get individual orders.
    If you have any special requirement, like in our case we have a requirement to get order 
    by customer id, than you can write a query for this and add a new method.
    If you notice below in order object I have used \". This is becuase order is a reserve word in JPA.
    If you table has the same name, then you need to use \".
*/

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
  
        @Query(
        value = "SELECT * FROM \"order\" o WHERE o.customer_id = ?1", 
        nativeQuery = true)
        Collection<Order> fetchOrdersByCustomerId(Integer customerId);

}