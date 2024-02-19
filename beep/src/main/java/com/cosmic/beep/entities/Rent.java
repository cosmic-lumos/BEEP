package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Rent {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @OneToOne
    private Goods goods;
    private Date beginDate;
    private Date returnDate;
}
