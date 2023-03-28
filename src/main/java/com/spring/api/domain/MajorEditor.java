package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MajorEditor {
    private final String name;

    @Builder
    public MajorEditor(String name) {
        this.name = name;
    }
}
