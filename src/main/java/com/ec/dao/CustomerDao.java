package com.ec.dao;

import com.ec.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerDao extends JpaRepository<Customer, Integer> {


}
