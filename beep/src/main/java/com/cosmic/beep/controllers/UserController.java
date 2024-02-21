package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.UserDto;
import com.cosmic.beep.entities.Rent;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.repositories.RentRepository;
import com.cosmic.beep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @GetMapping("/")
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User createUser(@RequestBody UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/{id}/rents")
    public List<Rent> allRents(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> rentRepository.findByUser(value)).orElse(null);
    }

}
