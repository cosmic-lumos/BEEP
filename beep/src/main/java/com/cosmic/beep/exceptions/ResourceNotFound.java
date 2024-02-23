package com.cosmic.beep.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(Long id){
        super("자원에 접근할 수 없습니다.");
    }
}
