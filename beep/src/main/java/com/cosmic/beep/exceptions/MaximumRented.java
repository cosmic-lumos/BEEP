package com.cosmic.beep.exceptions;

public class MaximumRented extends RuntimeException{
    public MaximumRented(){
        super("더 이상 빌릴 수 없습니다.");
    }
}
