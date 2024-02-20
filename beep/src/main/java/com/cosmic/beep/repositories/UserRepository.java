package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
