package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.PositionDto;
import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/")
    public Positions createPosition(@RequestBody PositionDto positionDto) {
        Positions positions = new Positions();
        positions.setName(positionDto.getName());
        return positionRepository.save(positions);
    }

    @GetMapping("/")
    public List<Positions> getPositions() {
        return positionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Positions> getPositionById(@PathVariable Long id){
        return positionRepository.findById(id);
    }

}
