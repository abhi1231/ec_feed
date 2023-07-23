package com.ec.controller;

import com.ec.dao.CustomerDao;
import com.ec.entity.Customer;
import com.ec.entity.Prize;
import com.ec.service.CustomerServiceImpln;
import com.ec.service.prize.PrizeImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpln customerServiceImpln;

    @Autowired
    PrizeImpl prize;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){

        List<Customer> data = customerServiceImpln.queryCustomer();

        return ResponseEntity.ok(data);
    }

    @GetMapping("/prize")
    public ResponseEntity<List<Prize>> getPrize(){

        List<Prize> data = prize.getPrize();

        return ResponseEntity.ok(data);
    }

}
