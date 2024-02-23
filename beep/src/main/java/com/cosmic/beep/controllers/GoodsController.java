package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.GoodsCreateDto;
import com.cosmic.beep.dtos.GoodsDto;
import com.cosmic.beep.services.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="물품관련", description = "물품관리에 관련된 API입니다.")
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
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

    @Operation(
            summary = "물품 정보를 변경합니다.",
            description = "이름, 위치, 카테고리를 변화시킵니다."
    )
    @PatchMapping("/{id}")
    public GoodsDto setGoodsCategoryById(@PathVariable Long id, @RequestBody GoodsCreateDto updateInfo){
        return GoodsDto.of(goodsService.updateGoods(id, updateInfo));
    }
}
