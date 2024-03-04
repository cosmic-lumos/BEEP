package com.cosmic.beep.dtos;

import lombok.Builder;

@Builder
public record GoodsCreateDto(String name, Long positionId, Long categoryId) {
}
