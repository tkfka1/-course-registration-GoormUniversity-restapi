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
    private final Long haveCredit;
    private final Major major;
    private final Long grade;



    @Builder
    public UserEditor(String studentId, String name, String password, String email, Long credit, Long haveCredit , Major major , Long grade) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.credit = credit;
        this.haveCredit = haveCredit;
        this.major = major;
        this.grade = grade;
    }
}
