package com.cosmic.beep.services;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Goods createGoods(GoodsCreateDto goodsCreateDto){
        return goodsRepository.save(Goods.builder()
                .name(goodsCreateDto.name())
                .positions(positionRepository.findById(goodsCreateDto.positionId()).orElseThrow(() -> new ResourceNotFound(goodsCreateDto.positionId())))
                .category(categoryRepository.findById(goodsCreateDto.categoryId()).orElseThrow(() -> new ResourceNotFound(goodsCreateDto.categoryId())))
                .build());
    }

    public Goods getGoods(Long id){
        return goodsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound(id));
    }

    public Goods updateGoods(Long id, GoodsCreateDto info){
        Goods goods = goodsRepository.findById(id).orElseThrow(()-> new ResourceNotFound(id));
        if(info.name() != null){
            goods.setName(info.name());
        }
        if(info.positionId() != null){
            goods.setPositions(positionRepository.findById(info.positionId()).orElseThrow(()->new ResourceNotFound(info.positionId())));
        }
        if(info.categoryId() != null){
            goods.setCategory(categoryRepository.findById(info.categoryId()).orElseThrow(()->new ResourceNotFound(info.categoryId())));
        }
        return goodsRepository.save(goods);
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

    public Category createCategory(String name){
        return categoryRepository.save(Category.builder()
                .name(name).build());
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
    }
}
