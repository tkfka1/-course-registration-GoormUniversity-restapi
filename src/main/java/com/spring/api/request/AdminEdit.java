package com.spring.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class AdminEdit {

    @NotBlank(message = "교원번호를 입력하세요.")
    private String adminId;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public AdminEdit(String adminId, String name, String password) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
    }


}
