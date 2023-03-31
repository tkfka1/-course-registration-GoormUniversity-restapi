package com.spring.api.request;

import com.spring.api.domain.Major;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSignup {

    private String studentId;
    private String name;
    private String password;
    private String email;
    private Long credit;
    private Major major;
    private Long haveCredit;
    private Long grade;
}
