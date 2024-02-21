package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.CategoryDto;
import com.cosmic.beep.entities.Category;
import com.cosmic.beep.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/")
    public Category createCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setIcon(categoryDto.getIcon());
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
