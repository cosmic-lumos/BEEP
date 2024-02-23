package com.cosmic.beep.repositories;

import com.cosmic.beep.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByPositionsId(Long id);
}
