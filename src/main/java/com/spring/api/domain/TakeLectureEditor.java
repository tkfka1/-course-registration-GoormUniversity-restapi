package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TakeLectureEditor {
    private final LectureClass lectureClass;
    private final User user;
    private final Long credit;

    @Builder
    public TakeLectureEditor(LectureClass lectureClass, User user , Long credit) {
        this.lectureClass = lectureClass;
        this.user = user;
        this.credit = credit;
    }
}