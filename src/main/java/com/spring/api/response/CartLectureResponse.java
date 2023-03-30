package com.spring.api.response;

import com.spring.api.domain.CartLecture;
import com.spring.api.domain.LectureClass;
import com.spring.api.domain.User;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class CartLectureResponse {

    private final Long id;
    private final LectureClass lectureClass;
    private final User user;
    private final Long credit;

    // 생성자 오버로딩
    public CartLectureResponse(CartLecture cartLecture) {
        this.id = cartLecture.getId();
        this.lectureClass = cartLecture.getLectureClass();
        this.user = cartLecture.getUser();
        this.credit = cartLecture.getCredit();

    }

    @Builder
    public CartLectureResponse(Long id, LectureClass lectureClass, User user, Long credit) {
        this.id = id;
        this.lectureClass = lectureClass;
        this.user = user;
        this.credit = credit;
    }
}
