package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Positions;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record PositionDto(Long id, String name, List<GoodsDto> goods) {
    public static PositionDto of(Positions positions){
        return PositionDto.builder()
                .id(positions.getId())
                .name(positions.getName())
                .goods(positions.getGoods() != null ? positions.getGoods().stream().map(GoodsDto::of).toList() : new ArrayList<>())
                .build();
    }
}
