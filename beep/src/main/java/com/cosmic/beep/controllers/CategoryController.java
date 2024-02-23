package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.CategoryDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.repositories.CategoryRepository;
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
    private CategoryRepository categoryRepository;

    @PostMapping("/")
    public Category createCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.name());
        category.setIcon(categoryDto.icon());
        return categoryRepository.save(category);
    }

    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryRepository.findById(id);
    }
}
