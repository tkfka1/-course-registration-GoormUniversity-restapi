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
public class LectureEdit {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;
    @NotNull(message = "전공을 입력해주세요.")
    private Major major;
    @NotNull(message = "학점을 입력해주세요.")
    private Long credit;
    @Builder
    public LectureEdit(String name, Major major, Long credit) {
        this.name = name;
        this.major = major;
        this.credit = credit;
    }

}
