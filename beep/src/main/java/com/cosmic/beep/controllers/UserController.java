package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.RentGoodsDto;
import com.cosmic.beep.dtos.UserDto;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.RentRepository;
import com.cosmic.beep.repositories.UserRepository;
import com.cosmic.beep.services.RentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="유저 API", description = "유저 정보를 관리하는 API입니다..")
@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name="basicAuth")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentService rentService;

    @GetMapping("/")
    public List<User> all() {
        return userRepository.findAll();
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

    @Operation(
            summary = "자기가 빌린 물품들을 가져옵니다."
    )
    @GetMapping("/rents")
    public List<RentGoodsDto> myRents(@AuthenticationPrincipal UserDetails userDetails){
        return rentService.getRentedOfUser(userDetails).stream().map(RentGoodsDto::of).toList();
    }
}
