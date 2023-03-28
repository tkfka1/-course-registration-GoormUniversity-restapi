package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LectureClassEditor {
    private final Long classMin;
    private final Long classMax;
    private final Lecture lecture;
    private final Professor professor;

    @Builder
    public LectureClassEditor(Long classMin, Long classMax, Lecture lecture, Professor professor) {
        this.classMin = classMin;
        this.classMax = classMax;
        this.lecture = lecture;
        this.professor = professor;
    }
}