package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Rented {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Goods goods;
    private Date beginDate;
    private Date returnDate;
}
