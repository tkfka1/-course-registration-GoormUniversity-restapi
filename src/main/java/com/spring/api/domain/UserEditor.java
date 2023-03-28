package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEditor {

    private final String studentId;
    private final String name;
    private final String password;
    private final String email;
    private final Long credit;
    private final Major major;



    @Builder
    public UserEditor(String studentId, String name, String password, String email, Long credit, Major major) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.credit = credit;
        this.major = major;
    }
}
