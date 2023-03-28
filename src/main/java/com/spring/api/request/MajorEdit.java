package com.spring.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
@ToString
public class MajorEdit {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;



    @Builder
    public MajorEdit(String name) {

        this.name = name;
    }

    public MajorEdit() {
    }

}
