package com.houselink.exception;

public class NotAdminException extends RuntimeException {
    public NotAdminException() {
        super("관리자 계정이 아닙니다.");
    }
}
