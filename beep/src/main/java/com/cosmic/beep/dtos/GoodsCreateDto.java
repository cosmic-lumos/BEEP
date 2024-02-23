package com.cosmic.beep.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsCreateDto {
    private String name;
    private Long positionId;
    private Long categoryId;
}
