package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Positions;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record PositionDto(String name, List<GoodsDto> goods) {
    public static PositionDto of(Positions positions){
        return PositionDto.builder()
                .name(positions.getName())
                .goods(positions.getGoods().stream().map(GoodsDto::of).toList())
                .build();
    }
}
