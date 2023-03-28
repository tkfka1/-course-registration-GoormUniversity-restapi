package com.spring.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class UserLogin {

    @NotBlank(message = "학생 번호를 입력해주세요.")
    private String studentId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public UserLogin(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

}
