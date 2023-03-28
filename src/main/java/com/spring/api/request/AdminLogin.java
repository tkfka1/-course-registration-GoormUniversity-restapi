package com.spring.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class AdminLogin {

    @NotBlank(message = "교원 번호를 입력해주세요.")
    private String adminId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public AdminLogin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }

}
