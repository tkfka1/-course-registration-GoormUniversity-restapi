package com.spring.api.response;

import com.spring.api.domain.Major;
import com.spring.api.domain.User;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class UserResponse {

    private final Long id;
    private final String name;
    private final String studentId;
    private final String email;
    private final Major major;
    private final Long credit;
    private final Long haveCredit;
    private final Long grade;

    // 생성자 오버로딩
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.studentId = user.getStudentId();
        this.email = user.getEmail();
        this.major = user.getMajor();
        this.credit = user.getCredit();
        this.haveCredit = user.getHaveCredit();
        this.grade = user.getGrade();

    }


    @Builder
    public UserResponse(Long id, String name, String studentId, String email, Major major, Long credit , Long haveCredit , Long grade) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.major = major;
        this.credit = credit;
        this.haveCredit = haveCredit;
        this.grade = grade;
    }
}
