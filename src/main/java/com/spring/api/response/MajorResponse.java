package com.spring.api.response;

import com.spring.api.domain.Major;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class MajorResponse {

    private final Long id;
    private final String name;

    // 생성자 오버로딩
    public MajorResponse(Major major) {
        this.id = major.getId();
        this.name = major.getName();
    }


    @Builder
    public MajorResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
