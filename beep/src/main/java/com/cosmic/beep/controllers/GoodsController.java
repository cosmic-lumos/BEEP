package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.dtos.GoodsDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.PositionRepository;
import com.cosmic.beep.services.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(
            summary = "모든 물품의 정보를 가져옵니다.",
            description = "물품의 이름, 위치, 카테고리, 빌림여부를 제공합니다."
    )
    @GetMapping("/")
    public List<GoodsDto> getGoods(){
        return goodsService.getAllGoods().stream().map(GoodsDto::of).toList();
    }

    @Operation(
            summary = "특정 물품의 현재 정보를 가져옵니다.",
            description = "물품의 정보를 제공합니다."
    )
    @GetMapping("/{id}")
    public GoodsDto getGoodsById(@PathVariable Long id){
        return GoodsDto.of(goodsService.getGoods(id));
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
