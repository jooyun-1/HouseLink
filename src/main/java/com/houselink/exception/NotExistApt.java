package com.houselink.exception;

public class NotExistApt extends RuntimeException {
    public NotExistApt() {
        super("존재하지 않는 아파트입니다.");
    }
}


