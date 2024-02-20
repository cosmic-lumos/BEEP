package com.cosmic.beep.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    @OneToMany
    private Set<Rent> rents;
    @OneToMany
    private Set<Rented> rented;
}
