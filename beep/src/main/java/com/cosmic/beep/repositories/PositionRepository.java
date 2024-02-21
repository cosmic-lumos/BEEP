package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Positions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Positions, Long> {
}
