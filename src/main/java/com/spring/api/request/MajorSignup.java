package com.spring.api.request;

import lombok.Builder;
import lombok.Data;

@Data
public class MajorSignup {
    private String name;

    @Builder
    public MajorSignup(String name) {
        this.name = name;
    }
    public MajorSignup() {
    }
}

