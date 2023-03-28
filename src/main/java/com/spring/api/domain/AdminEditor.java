package com.spring.api.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminEditor {

    private final String adminId;
    private final String name;
    private final String password;



    @Builder
    public AdminEditor(String adminId, String name, String password) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;

    }
}
