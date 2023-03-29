package com.spring.api.response;


import com.spring.api.domain.Lecture;
import com.spring.api.domain.LectureClass;
import com.spring.api.domain.Professor;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */

@Getter
public class LectureClassResponse {

    private final Long id;
    private final Long classMax;
    private final Long classMin;
    private final Long classPeople;
    private final Lecture lecture;
    private final Professor professor;
    private final String explanation;
    private final Long period;
    private final Long week;

    // 생성자 오버로딩
    public LectureClassResponse(LectureClass lectureClass) {
        this.id = lectureClass.getId();
        this.classMax = lectureClass.getClassMax();
        this.classMin = lectureClass.getClassMin();
        this.classPeople = lectureClass.getClassPeople();
        this.lecture = lectureClass.getLecture();
        this.professor = lectureClass.getProfessor();
        this.explanation = lectureClass.getExplanation();
        this.period = lectureClass.getPeriod();
        this.week = lectureClass.getWeek();

    }

    @Builder
    public LectureClassResponse(Long id, Long classMax, Long classMin, Long classPeople, Lecture lecture, Professor professor, String explanation, Long period, Long week) {
        this.id = id;
        this.classMax = classMax;
        this.classMin = classMin;
        this.classPeople = classPeople;
        this.lecture = lecture;
        this.professor = professor;
        this.explanation = explanation;
        this.period = period;
        this.week = week;
    }
}
