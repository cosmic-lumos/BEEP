package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
