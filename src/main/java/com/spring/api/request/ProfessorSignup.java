package com.spring.api.request;

import com.spring.api.domain.Major;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorSignup {
    private String name;
    private Major major;

}

