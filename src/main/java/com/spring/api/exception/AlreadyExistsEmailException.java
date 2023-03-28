package com.spring.api.exception;

public class AlreadyExistsEmailException extends DefaultException {

    private static final String MESSAGE = "이미 가입된 학번입니다.";

    public AlreadyExistsEmailException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
