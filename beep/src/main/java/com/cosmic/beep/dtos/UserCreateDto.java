package com.cosmic.beep.dtos;

public record UserCreateDto(String username, String password, String matchingPassword, String firstName, String lastName, String email) {
}
