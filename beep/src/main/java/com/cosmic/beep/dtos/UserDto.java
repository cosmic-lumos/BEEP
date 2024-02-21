package com.cosmic.beep.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String matchingPassword;
    private String email;
}
