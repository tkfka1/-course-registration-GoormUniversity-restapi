package com.spring.api.exception;

public class AlreadyExistsPeopleOverException extends DefaultException {

    private static final String MESSAGE = "인원이 초과되었습니다.";

    public AlreadyExistsPeopleOverException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
