package com.spring.api.response;

import com.spring.api.domain.Admin;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class AdminResponse {

    private final Long id;
    private final String name;
    private final String adminId;

    // 생성자 오버로딩
    public AdminResponse(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.adminId = admin.getAdminId();
    }


    @Builder
    public AdminResponse(Long id, String name , String adminId) {
        this.id = id;
        this.name = name;
        this.adminId = adminId;
    }
}
