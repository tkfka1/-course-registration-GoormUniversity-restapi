package com.spring.api.request;


import com.spring.api.domain.Lecture;
import com.spring.api.domain.Professor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LectureClassSignup {
    private Long classMin;
    private Long classMax;
    private Long classPeople;
    private Lecture lecture;
    private Professor professor;
    private Long period;
    private Long week;
    private String explanation;

}

