package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Position {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "position")
    private Set<Goods> goods;
}
