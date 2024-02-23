package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.dtos.GoodsDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import com.cosmic.beep.services.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="물품관련", description = "물품관리에 관련된 API입니다.")
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Operation(
            summary = "새로운 물품을 추가합니다.",
            description = "물품의 이름과 위치 정보, 카테고리를 입력으로 새로운 물품을 추가합니다."
    )
    @PostMapping("/")
    public GoodsDto createGoods(@RequestBody @Valid GoodsCreateDto goodsCreateDto){
        return GoodsDto.of(goodsService.createGoods(goodsCreateDto));
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
