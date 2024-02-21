package com.cosmic.beep.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class GoodsDto {
    private String name;
    private Long positionId;
    private Set<Long> categoryIds;
}
