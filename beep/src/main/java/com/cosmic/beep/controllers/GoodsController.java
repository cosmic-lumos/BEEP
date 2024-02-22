package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public Goods createGoods(@RequestBody GoodsCreateDto goodsCreateDto){
        Goods goods = new Goods();
        goods.setName(goodsCreateDto.getName());
        if(goodsCreateDto.getPositionId() != null){
            Optional<Positions> position = positionRepository.findById(goodsCreateDto.getPositionId());
            position.ifPresent(goods::setPositions);
        }
        if(goodsCreateDto.getCategoryIds() != null){
            goods.setCategory(categoryRepository.findById(goodsCreateDto.getCategoryIds()).get());
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
            throw new EntityNotFoundException("goods가 없습니다.");
        }
        Optional<Positions> position = positionRepository.findById(positionId);
        if(position.isEmpty()){
            throw new EntityNotFoundException("positions이 없습니다.");
        }
        goods.get().setPositions(position.get());
        goodsRepository.save(goods.get());
        return goods;
    }

    @GetMapping("/positions/{id}")
    public List<Goods> getGoodsByPositionId(@PathVariable Long id){
        if(positionRepository.findById(id).isEmpty()){
            throw new ResourceNotFound(id);
        }
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
        goods.get().setCategory(category.get());
        goodsRepository.save(goods.get());
        return goods;
    }
}
