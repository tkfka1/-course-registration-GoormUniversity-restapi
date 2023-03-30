package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CartLectureEditor {
    private final LectureClass lectureClass;
    private final User user;
    private final Long credit;

    @Builder
    public CartLectureEditor(LectureClass lectureClass, User user , Long credit) {
        this.lectureClass = lectureClass;
        this.user = user;
        this.credit = credit;
    }
}