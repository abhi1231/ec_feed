package com.ec.controller;

import com.ec.entity.Prize;
import com.ec.service.prize.PrizeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/price")
public class PrizeController {

    @Autowired
    private PrizeImpl prizeImpl;

    @GetMapping("/prize")
    public ResponseEntity<List<Prize>> getPrize(){

        List<Prize> data = prizeImpl.getPrize();

        return ResponseEntity.ok(data);
    }

}
