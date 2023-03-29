package com.spring.api.request;


import com.spring.api.domain.Lecture;
import com.spring.api.domain.Major;
import com.spring.api.domain.Professor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class LectureClassEdit {

    @NotNull(message = "최소인원수를 입력해주세요.")
    private Long classMin;
    @NotNull(message = "최대인원수를 입력해주세요.")
    private Long classMax;
    @NotNull(message = "현재인원수를 입력해주세요.")
    private Long classPeople;
    @NotBlank(message = "설명을 입력해주세요.")
    private String explanation;
    @NotNull(message = "교시를 입력해주세요.")
    private Long period;
    @NotNull(message = "요일을 입력해주세요.")
    private Long week;
    @NotNull(message = "교수를 입력해주세요.")
    private Professor professor;
    @NotNull(message = "수업을 입력해주세요.")
    private Lecture lecture;

    @Builder
    public LectureClassEdit(Long classMin, Long classMax, Long classPeople, String explanation, Long period, Long week, Professor professor, Lecture lecture) {
        this.classMin = classMin;
        this.classMax = classMax;
        this.classPeople = classPeople;
        this.explanation = explanation;
        this.period = period;
        this.week = week;
        this.professor = professor;
        this.lecture = lecture;
    }

}
