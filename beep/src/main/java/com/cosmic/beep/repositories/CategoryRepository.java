package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
