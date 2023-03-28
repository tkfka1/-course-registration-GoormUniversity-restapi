package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LectureEditor {
    private final String name;
    private final Long credit;
    private final Major major;

    @Builder
    public LectureEditor(String name, Long credit, Major major) {
        this.name = name;
        this.credit = credit;
        this.major = major;
    }
}