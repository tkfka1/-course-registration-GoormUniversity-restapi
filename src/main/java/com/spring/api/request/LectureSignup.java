package com.spring.api.request;

import com.spring.api.domain.Major;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LectureSignup {
    private String name;
    private Major major;
    private Long credit;

}

