package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.RentCreateDto;
import com.cosmic.beep.dtos.RentGoodsDto;
import com.cosmic.beep.services.RentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="대여/반납 관련", description = "물품 대여 및 반납과 관련된 API입니다.")
@RestController
@RequestMapping("/api/rent")
@SecurityRequirement(name="basicAuth")
@Log4j2
public class RentController {
    @Autowired
    private RentService rentService;

    @Operation(
            summary = "물건을 빌립니다.",
            description = "유저 정보가 반드시 필요합니다."
    )
    @PostMapping("/")
    public List<RentGoodsDto> createRent(@RequestBody @Valid RentCreateDto rentCreateDto, @AuthenticationPrincipal UserDetails userDetails){
        return rentService.rentGoods(userDetails, rentCreateDto.goodsId()).stream().map(RentGoodsDto::of).toList();
    }

    @Operation(
            summary = "물건을 반납합니다.",
            description = "물건의 id를 parameter로 받고 해당하는 물건이 반납됩니다."
    )
    @DeleteMapping("/{id}")
    public List<RentGoodsDto> returnRented(@PathVariable Long id){
        return rentService.returnGoods(id).stream().map(RentGoodsDto::of).toList();
    }
}
