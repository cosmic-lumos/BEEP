package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
