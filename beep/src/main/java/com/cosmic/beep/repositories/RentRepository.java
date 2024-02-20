package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
