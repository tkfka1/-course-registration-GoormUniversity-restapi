package com.spring.api.exception;

public class AlreadyExistsTakeOverException extends DefaultException {

    private static final String MESSAGE = "수강학점이 초과되었습니다.";

    public AlreadyExistsTakeOverException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
