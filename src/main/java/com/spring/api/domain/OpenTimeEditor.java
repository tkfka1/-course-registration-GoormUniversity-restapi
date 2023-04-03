package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OpenTimeEditor {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    @Builder
    public OpenTimeEditor(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
