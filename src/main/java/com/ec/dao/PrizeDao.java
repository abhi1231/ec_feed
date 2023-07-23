package com.ec.dao;

import com.ec.entity.Customer;
import com.ec.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface PrizeDao extends JpaRepository<Prize, Integer> {


}
