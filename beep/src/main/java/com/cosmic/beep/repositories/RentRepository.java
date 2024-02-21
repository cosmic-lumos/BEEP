package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Rent;
import com.cosmic.beep.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByUser(User user);
}
