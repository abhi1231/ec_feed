package com.ec.controller;


import com.ec.entity.Customer;
import com.ec.service.CustomerServiceImpln;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpln customerServiceImpln;

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerServiceImpln.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerServiceImpln.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerServiceImpln.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerServiceImpln.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerServiceImpln.deleteCustomer(id);
    }



}
