package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Rented;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedRepository extends JpaRepository<Rented, Long> {
}
