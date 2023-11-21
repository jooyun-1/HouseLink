package com.houselink.exception;

public class AlreadyExistAptCode  extends RuntimeException {
    public AlreadyExistAptCode() {
        super("이미 존재하는 아파트 코드입니다.");
    }
}
