package com.ec.service.prize;

import com.ec.dao.PrizeDao;
import com.ec.entity.Prize;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PrizeImpl implements PrizeService{

    @Autowired
    private PrizeDao prizeDao;

    @Override
    public List<Prize> getPrize() {
        return prizeDao.findAll();
    }
}
