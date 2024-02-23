package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Positions;
import com.cosmic.beep.exceptions.ResourceNotFound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Positions, Long> {
}
