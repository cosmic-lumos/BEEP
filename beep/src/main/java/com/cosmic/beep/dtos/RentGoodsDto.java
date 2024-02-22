package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.Rent;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RentGoodsDto(Long id, String name, @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDateTime returnDate, String category){
    public static RentGoodsDto from(Rent rent){
        return new RentGoodsDto(rent.getGoods().getId(), rent.getGoods().getName(), rent.getReturnDate(), rent.getGoods().getCategory().getName());
    }
}
