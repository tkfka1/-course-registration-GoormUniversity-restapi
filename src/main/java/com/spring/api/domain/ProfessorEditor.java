package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProfessorEditor {
    private final String name;
    private final Major major;

    @Builder
    public ProfessorEditor(String name, Major major) {
        this.name = name;
        this.major = major;
    }
}
