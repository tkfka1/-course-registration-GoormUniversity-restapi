package com.spring.api.response;

import com.spring.api.domain.*;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class TakeLectureResponse {

    private final Long id;
    private final LectureClass lectureClass;
    private final User user;

    // 생성자 오버로딩
    public TakeLectureResponse(TakeLecture takeLecture) {
        this.id = takeLecture.getId();
        this.lectureClass = takeLecture.getLectureClass();
        this.user = takeLecture.getUser();

    }

    @Builder
    public TakeLectureResponse(Long id, LectureClass lectureClass, User user) {
        this.id = id;
        this.lectureClass = lectureClass;
        this.user = user;
    }
}
