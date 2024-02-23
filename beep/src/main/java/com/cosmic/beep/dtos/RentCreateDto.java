package com.cosmic.beep.dtos;

import lombok.Builder;

@Builder
public record RentCreateDto(Long goodsId, Long userId) {
}
