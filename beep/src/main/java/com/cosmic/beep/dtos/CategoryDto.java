package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Category;
import lombok.Data;

import java.util.List;

public record CategoryDto(String name, String icon) {
    public static CategoryDto from(Category category) {
        return new CategoryDto(category.getName(), category.getIcon());
    }
}
