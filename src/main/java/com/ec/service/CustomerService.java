package com.ec.service;

import com.ec.entity.Customer;

import java.util.List;

public interface CustomerService {

        List<Customer> queryCustomer();

    List<Customer> queryCustomerByName(String firstName);

    int insertCustomer(Customer customer);

    int queryCountCustomer();
}
