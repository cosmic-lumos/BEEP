package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Category;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryDto(Long id, String name, List<GoodsDto> goods) {
    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .goods(category.getGoods().stream().map(GoodsDto::of).toList())
                .build();
    }
}
