package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.RentGoodsDto;
import com.cosmic.beep.dtos.UserCreateDto;
import com.cosmic.beep.dtos.UserDto;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.RentRepository;
import com.cosmic.beep.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @GetMapping("/")
    public List<User> all() {
        return userRepository.findAll();
    }

    @Operation(
            summary = "새로운 유저를 생성합니다."
    )
    @PostMapping("/")
    public UserDto createUser(@RequestBody @Valid UserCreateDto userCreateDto){
        if(!userCreateDto.password().equals(userCreateDto.matchingPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return UserDto.of(userRepository.save(User.builder()
                .username(userCreateDto.username())
                .password(userCreateDto.password())
                .firstName(userCreateDto.firstName())
                .lastName(userCreateDto.lastName())
                .build()));
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return UserDto.of(userRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id)));
    }

    @Operation(
            summary = "유저가 빌린 물품들을 가져옵니다."
    )
    @GetMapping("/{id}/rents")
    public List<RentGoodsDto> allRents(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> rentRepository.findByUser(value).stream().map(RentGoodsDto::of).toList()).orElse(null);
    }

}
