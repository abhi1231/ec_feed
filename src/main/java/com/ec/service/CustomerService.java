package com.ec.service;

import com.ec.entity.Customer;

import java.util.List;


public interface CustomerService {

    public List<Customer> getAllCustomers();
    public Customer getCustomerById(Long id);
    public Customer updateCustomer(Long id, Customer updatedCustomer);
    public void deleteCustomer(Long id);
}
