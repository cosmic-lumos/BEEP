package com.cosmic.beep.dtos;

import com.cosmic.beep.entities.User;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record UserDto(Long id, String username, String fullName, List<RentGoodsDto> rents) {
    public static UserDto of(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getLastName()+user.getFirstName())
                .rents(user.getRents() != null ? user.getRents().stream().map(RentGoodsDto::of).toList(): new ArrayList<>())
                .build();
    }
}
