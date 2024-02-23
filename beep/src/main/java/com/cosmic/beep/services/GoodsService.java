package com.cosmic.beep.services;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Goods createGoods(GoodsCreateDto goodsCreateDto){
        return goodsRepository.save(Goods.builder()
                .name(goodsCreateDto.getName())
                .positions(positionRepository.findById(goodsCreateDto.getPositionId()).orElseThrow(() -> new ResourceNotFound(goodsCreateDto.getPositionId())))
                .category(categoryRepository.findById(goodsCreateDto.getCategoryId()).orElseThrow(() -> new ResourceNotFound(goodsCreateDto.getCategoryId())))
                .build());
    }

    public Goods getGoods(Long id){
        return goodsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound(id));
    }

    public List<Goods> getAllGoods(){
        return goodsRepository.findAll();
    }

    public Positions getPosition(Long id){
        return positionRepository.findById(id).orElseThrow(()->new ResourceNotFound(id));
    }

    public List<Positions> getAllPositions(){
        return positionRepository.findAll();
    }

    public Positions createPosition(String name){
        return positionRepository.save(Positions.builder().name(name).build());
    }
}
