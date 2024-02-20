package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
