package com.zaynsolution.ordermanagement;
import com.zaynsolution.ordermanagement.entity.Complain;
import com.zaynsolution.ordermanagement.entity.Customer;
import com.zaynsolution.ordermanagement.entity.Order;
import com.zaynsolution.ordermanagement.repository.CustomerRepository;
import com.zaynsolution.ordermanagement.repository.OrderRepository;
import com.zaynsolution.ordermanagement.repository.ComplainRepository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/* This is the main class where we have all the logic for Order Management api. 
 * It has multiple methods. Each method has a seperate URL. 
 * for example: http://localhost:8080/ordermanagement/allcustomers
 * The main api URL is http://localhost:8080/ordermanagement/
 */

@Controller    
@RequestMapping(path="/ordermanagement") 
public class ApplicationController {
    

    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired 
    private ComplainRepository complainRepository;

    @Autowired 
    private OrderRepository orderRepository;

    @RequestMapping(method=RequestMethod.GET, value="/")
    public @ResponseBody String defaultMethod() {
        return "Hi, this is an order management system. It uses Postgres to store customers, orders and complaints.";
    }
 

    @RequestMapping(method=RequestMethod.POST, value="/addcustomer")
    public @ResponseBody String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Customer Details are Saved";
    }
 
    
    @RequestMapping(method=RequestMethod.POST, value="/addorder")
    public @ResponseBody String addCustomer(@RequestBody Order order) {
        orderRepository.save(order);
        return "Order Details are Saved";
    }

    @RequestMapping(method=RequestMethod.POST, value="/addcomplain")
    public @ResponseBody String addCustomer(@RequestBody Complain complain) {
        complainRepository.save(complain);
        return "Complain Details are Saved";
    }    

    @GetMapping(path="/allcustomers")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    @GetMapping(path="/allorders")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(path="/allcomplains")
    public @ResponseBody Iterable<Complain> getAllComplains() {
        return complainRepository.findAll();
    }


    @GetMapping(path="/customer")
    public @ResponseBody Optional<Customer> getCustomer(@RequestParam Integer id) {
        return customerRepository.findById(id);
    }

    @GetMapping(path="/complain")
    public @ResponseBody Optional<Complain> getComplain(@RequestParam Integer id) {
        return complainRepository.findById(id);
    }

    @GetMapping(path="/order")
    public @ResponseBody Optional<Order> getOrder(@RequestParam Integer id) {
        return orderRepository.findById(id);
    }



    @GetMapping(path="/complainbycustomer")
    public @ResponseBody Collection<Complain> getComplainsByCustomerId(@RequestParam Integer id) {
        return complainRepository.fetchComplainsByCustomerId(id);
    }

    @GetMapping(path="/orderbycustomer")
    public @ResponseBody Collection<Order> getOrdersByCustomerId(@RequestParam Integer id) {
        return orderRepository.fetchOrdersByCustomerId(id);
    }

}
