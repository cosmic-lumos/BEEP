package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.NameOnlyDto;
import com.cosmic.beep.dtos.PositionDto;
import com.cosmic.beep.services.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="위치 및 카테고리 관련", description = "위치 및 카테고리를 관리하는 API입니다.")
@RestController
@RequestMapping("/api/positions")
@SecurityRequirement(name="basicAuth")
public class PositionsController {
    @Autowired
    private GoodsService goodsService;

    @Operation(
            summary = "위치를 새롭게 만듭니다.",
            description = "중복된 이름을 만들 수는 없습니다."
    )
    @PostMapping("/")
    public PositionDto createPosition(@RequestBody NameOnlyDto nameDto) {
        return PositionDto.of(goodsService.createPosition(nameDto.name()));
    }

    @Operation(
            summary = "모든 위치 정보를 불러옵니다.",
            description = "모든 위치에 존재하는 물건들도 같이 불러옵니다."
    )
    @GetMapping("/")
    public List<PositionDto> getPositions() {
        return goodsService.getAllPositions().stream().map(PositionDto::of).toList();
    }

    @Operation(
            summary = "특정 위치의 물건들을 불러옵니다.",
            description = "id에 해당하는 위치의 물건들을 불러옵니다."
    )
    @GetMapping("/{id}")
    public PositionDto getPositionById(@PathVariable Long id){
        return PositionDto.of(goodsService.getPosition(id));
    }

}
