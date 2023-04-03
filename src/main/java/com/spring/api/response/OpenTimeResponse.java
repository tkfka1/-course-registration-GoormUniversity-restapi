package com.spring.api.response;

import com.spring.api.domain.OpenTime;
import com.spring.api.domain.OpenTimeEditor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class OpenTimeResponse {

    private final Long id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;


    // 생성자 오버로딩
    public OpenTimeResponse(OpenTime openTime) {
        this.id = openTime.getId();
        this.startTime = openTime.getStartTime();
        this.endTime = openTime.getEndTime();

    }


    @Builder
    public OpenTimeResponse(Long id, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
