package com.cosmic.beep.services;

import com.cosmic.beep.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
}
