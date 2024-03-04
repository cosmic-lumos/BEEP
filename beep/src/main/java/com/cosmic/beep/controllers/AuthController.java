package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.UserCreateDto;
import com.cosmic.beep.dtos.UserDto;
import com.cosmic.beep.dtos.accounts.LoginDto;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.exceptions.SignUpException;
import com.cosmic.beep.repositories.RoleRepository;
import com.cosmic.beep.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.username(), loginDto.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User signed-in successfully!.";
    }

    @PostMapping("/signup")
    @Operation(
            summary = "새로운 유저를 생성합니다."
    )
    public UserDto createUser(@RequestBody @Valid UserCreateDto userCreateDto){
        if(!userCreateDto.password().equals(userCreateDto.matchingPassword())){
            throw new SignUpException("비밀번호가 일치하지 않습니다.");
        }
        if(userRepository.findByUsernameOrEmail(userCreateDto.username(), userCreateDto.email()).isPresent()){
            throw new SignUpException("이미 존재하는 계정입니다.");
        }
        return UserDto.of(userRepository.save(User.builder()
                .username(userCreateDto.username())
                .password(passwordEncoder.encode(userCreateDto.password()))
                .firstName(userCreateDto.firstName())
                .lastName(userCreateDto.lastName())
                .roles(Collections.singletonList(roleRepository.findByName("ROLE_USER").orElseThrow(() -> new ResourceNotFound(0L))))
                .email(userCreateDto.email())
                .build()));
    }
}
