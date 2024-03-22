package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Positions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Positions, Long> {
    Optional<Positions> findByName(String name);
}
