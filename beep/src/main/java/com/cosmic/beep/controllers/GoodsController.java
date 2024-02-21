package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.GoodsDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping("/")
    public Goods createGoods(@RequestBody GoodsDto goodsDto){
        Goods goods = new Goods();
        goods.setName(goodsDto.getName());
        if(goodsDto.getPositionId() != null){
            Optional<Positions> position = positionRepository.findById(goodsDto.getPositionId());
            position.ifPresent(goods::setPositions);
        }
        if(goodsDto.getCategoryIds() != null){
            goods.setCategories(new HashSet<>(categoryRepository.findAllById(goodsDto.getCategoryIds())));
        }
        return goodsRepository.save(goods);
    }

    @GetMapping("/")
    public List<Goods> getGoods(){
        return goodsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Goods> getGoodsById(@PathVariable Long id){
        return goodsRepository.findById(id);
    }

    @PostMapping("/{id}/positions/{positionId}")
    public Optional<Goods> setGoodsPositionById(@PathVariable Long id, @PathVariable Long positionId){
        Optional<Goods> goods = goodsRepository.findById(id);
        if(goods.isEmpty()){
            return goods;
        }
        Optional<Positions> position = positionRepository.findById(positionId);
        if(position.isEmpty()){
            return goods;
        }
        goods.get().setPositions(position.get());
        goodsRepository.save(goods.get());
        return goods;
    }

    @GetMapping("/positions/{id}")
    public List<Goods> getGoodsByPositionId(@PathVariable Long id){
        return goodsRepository.findByPositionsId(id);
    }

    @PostMapping("/{id}/category/{categoryId}")
    public Optional<Goods> setGoodsCategoryById(@PathVariable Long id, @PathVariable Long categoryId){
        Optional<Goods> goods = goodsRepository.findById(id);
        if(goods.isEmpty()){
            return goods;
        }
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()){
            return goods;
        }
        goods.get().getCategories().add(category.get());
        goodsRepository.save(goods.get());
        return goods;
    }
}
