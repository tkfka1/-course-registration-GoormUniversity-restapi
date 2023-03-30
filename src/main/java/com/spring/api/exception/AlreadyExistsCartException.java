package com.spring.api.exception;

public class AlreadyExistsCartException extends DefaultException {

    private static final String MESSAGE = "장바구니에 이미 등록된 강의입니다.";

    public AlreadyExistsCartException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
