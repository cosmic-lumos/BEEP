package com.cosmic.beep.services;

import com.cosmic.beep.entities.Rent;
import com.cosmic.beep.entities.Rented;
import com.cosmic.beep.entities.User;
import com.cosmic.beep.exceptions.MaximumRented;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.GoodsRepository;
import com.cosmic.beep.repositories.RentRepository;
import com.cosmic.beep.repositories.RentedRepository;
import com.cosmic.beep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentedRepository rentedRepository;

    public List<Rent> getRentedOfUser(UserDetails userDetails){
        return rentRepository.findByUser(userRepository.findByUsernameOrEmail(userDetails.getUsername(), userDetails.getUsername()).orElseThrow(()->new ResourceNotFound(0L)));
    }

    public List<Rent> rentGoods(UserDetails userDetails, Long goodsId){
        User user = userRepository.findByUsernameOrEmail(userDetails.getUsername(), userDetails.getUsername()).orElseThrow(()->new ResourceNotFound(0L));
        if(rentRepository.findByUser(user).size() >= 5){
            throw new MaximumRented();
        }
        rentRepository.save(Rent.builder()
                .user(user)
                .goods(goodsRepository.findById(goodsId).orElseThrow(()->new ResourceNotFound(goodsId)))
                .beginDate(LocalDateTime.now())
                .returnDate(LocalDateTime.now().plusDays(7))
                .build());
        return getRentedOfUser(userDetails);
    }

    public List<Rent> returnGoods(Long goodsId){
        Rent rent = rentRepository.findByGoodsId(goodsId).orElseThrow(()->new ResourceNotFound(goodsId));
        rentedRepository.save(Rented.builder()
                .user(rent.getUser())
                .goods(rent.getGoods())
                .beginDate(rent.getBeginDate())
                .returnedDate(LocalDateTime.now())
                .build());
        rentRepository.delete(rent);
        return rentRepository.findByUserId(rent.getId());
    }
}
