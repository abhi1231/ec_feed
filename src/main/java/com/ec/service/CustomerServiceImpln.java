package com.ec.service;

import com.ec.dao.CustomerDao;
import com.ec.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpln implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> queryCustomer() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> queryCustomerByName(String firstName) {
        return null;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int queryCountCustomer() {
        return 0;
    }
}
