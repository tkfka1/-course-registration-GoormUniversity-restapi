package com.spring.api.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OpenTimeSignup {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
