package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Rent;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RentGoodsDto(Long id, String name, @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDateTime returnDate, String category){
    public static RentGoodsDto of(Rent rent){
        return RentGoodsDto.builder().id(rent.getGoods().getId())
                .name(rent.getGoods().getName())
                .returnDate(rent.getReturnDate())
                .category(rent.getGoods().getCategory().getName())
                .build();
    }
}
