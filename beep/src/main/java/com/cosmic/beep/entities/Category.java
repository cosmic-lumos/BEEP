package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Category {
    @Id
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Goods> goods;
}
