package com.cosmic.beep.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Goods {
    @Id
    private Integer id;
    private String name;
    @OneToOne
    private Rent rent;
    @ManyToMany
    private Set<Category> categories;
    @ManyToOne
    private Position position;
}
