package com.ec.service;

import com.ec.dao.CustomerDao;
import com.ec.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpln implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = customerDao.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstname(updatedCustomer.getFirstname());
            existingCustomer.setLastname(updatedCustomer.getLastname());
            existingCustomer.setGender(updatedCustomer.getGender());
            existingCustomer.setPhoneno(updatedCustomer.getPhoneno());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setCity(updatedCustomer.getCity());
            existingCustomer.setState(updatedCustomer.getState());
            existingCustomer.setCountry(updatedCustomer.getCountry());
            existingCustomer.setZip(updatedCustomer.getZip());
            return customerDao.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }
}

