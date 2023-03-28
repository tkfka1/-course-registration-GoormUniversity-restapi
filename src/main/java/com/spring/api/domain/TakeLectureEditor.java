package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TakeLectureEditor {
    private final LectureClass lectureClass;
    private final User user;

    @Builder
    public TakeLectureEditor(LectureClass lectureClass, User user) {
        this.lectureClass = lectureClass;
        this.user = user;
    }
}