package com.spring.api.response;

import com.spring.api.domain.Lecture;
import com.spring.api.domain.Major;
import com.spring.api.domain.Professor;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class LectureResponse {

    private final Long id;
    private final String name;
    private final Major major;
    private final Long credit;

    // 생성자 오버로딩
    public LectureResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.major = lecture.getMajor();
        this.credit = lecture.getCredit();

    }

    @Builder
    public LectureResponse(Long id, String name, Long credit , Major major) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.credit = credit;
    }
}
