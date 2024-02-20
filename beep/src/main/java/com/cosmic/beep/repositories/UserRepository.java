package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
}
