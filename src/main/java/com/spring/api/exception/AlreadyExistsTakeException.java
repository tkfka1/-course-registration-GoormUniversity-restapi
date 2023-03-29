package com.spring.api.exception;

public class AlreadyExistsTakeException extends DefaultException {

    private static final String MESSAGE = "이미 수강신청된 강의입니다.";

    public AlreadyExistsTakeException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
