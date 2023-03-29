package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LectureClassEditor {
    private final Long classMin;
    private final Long classMax;
    private final Long classPeople;
    private final Lecture lecture;
    private final Professor professor;
    private final Long period;
    private final Long week;
    private final String explanation;

    @Builder
    public LectureClassEditor(Long classMin, Long classMax,Long classPeople, Lecture lecture, Professor professor, Long period, Long week, String explanation) {
        this.classMin = classMin;
        this.classMax = classMax;
        this.classPeople = classPeople;
        this.lecture = lecture;
        this.professor = professor;
        this.period = period;
        this.week = week;
        this.explanation = explanation;
    }
}