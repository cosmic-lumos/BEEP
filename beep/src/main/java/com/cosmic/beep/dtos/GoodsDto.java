package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Goods;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {
    private Long id;
    private String name;
    private String category;
    private String position;
    private Boolean isRenting;

    public static GoodsDto of(Goods goods){
        return GoodsDto.builder()
                .id(goods.getId())
                .name(goods.getName())
                .category(goods.getCategory().getName())
                .position(goods.getPositions().getName())
                .isRenting(goods.getRent()!=null)
                .build();
    }
}
