package com.houselink.exception;

public class AlreadyExistAptNo  extends RuntimeException {
    public AlreadyExistAptNo() {
        super("이미 존재하는 아파트 번호입니다.");
    }
}
