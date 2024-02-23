package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.CategoryDto;
import com.cosmic.beep.dtos.NameOnlyDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.repositories.CategoryRepository;
import com.cosmic.beep.services.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="위치 및 카테고리 관련", description = "위치 및 카테고리를 관리하는 API입니다.")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private GoodsService goodsService;

    @Operation(
            summary = "카테고리를 생성합니다."
    )
    @PostMapping("/")
    public CategoryDto createCategory(@RequestBody NameOnlyDto categoryName){
        return CategoryDto.of(goodsService.createCategory(categoryName.name()));
    }

    @Operation(
            summary = "모든 카테고리를 불러옵니다."
    )
    @GetMapping("/")
    public List<CategoryDto> getCategories(){
        return goodsService.getAllCategories().stream().map(CategoryDto::of).toList();
    }

    @Operation(
            summary = "특정 카테고리의 물품들을 불러옵니다."
    )
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return CategoryDto.of(goodsService.getCategory(id));
    }
}
