package com.cosmic.beep.controllers;

import com.cosmic.beep.dtos.RentDto;
import com.cosmic.beep.entities.Goods;
import com.cosmic.beep.entities.Rent;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.RentRepository;
import com.cosmic.beep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rent")
public class RentController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping("/")
    public Rent createRent(@RequestBody RentDto rentDto){
        Rent rent = new Rent();
        Optional<User> user = userRepository.findById(rentDto.getUserId());
        if(user.isEmpty()){
            return null;
        }
        rent.setUser(user.get());
        Optional<Goods> goods = goodsRepository.findById(rentDto.getGoodsId());
        if(goods.isEmpty()){
            return null;
        }
        rent.setGoods(goods.get());
        rent.setBeginDate(new Date());
        rent.setReturnDate(new Date());
        return rentRepository.save(rent);
    }

    @PostMapping("/return/{id}")
    public List<Rent> returnRented(@PathVariable Long id){
        Optional<Rent> rent = rentRepository.findByGoodsId(id);
        if(rent.isEmpty()){
            return null;
        }
        User user = rent.get().getUser();
        rentRepository.delete(rent.get());
        return rentRepository.findByUser(user);
    }
}
