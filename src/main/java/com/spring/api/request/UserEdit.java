package com.spring.api.request;

import com.spring.api.domain.Major;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class UserEdit {

    @NotBlank(message = "교원번호를 입력하세요.")
    private String studentId;
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotNull(message = "수강학점을 입력해주세요.")
    private Long credit;
    @NotNull(message = "현재학점을 입력해주세요.")
    private Long haveCredit;
    @NotNull(message = "전공을 입력해주세요.")
    private Major major;
    @NotNull(message = "현재학년을 입력해주세요.")
    private Long grade;

    @Builder
    public UserEdit(String studentId, String name, String password, String email, Long credit, Long haveCredit , Major major , Long grade) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.credit = credit;
        this.haveCredit = haveCredit;
        this.major = major;
        this.grade = grade;
    }


}
