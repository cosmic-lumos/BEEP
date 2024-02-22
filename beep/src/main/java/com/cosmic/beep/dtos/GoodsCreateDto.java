package com.cosmic.beep.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class GoodsCreateDto {
    private String name;
    private Long positionId;
    private Long categoryIds;
}
