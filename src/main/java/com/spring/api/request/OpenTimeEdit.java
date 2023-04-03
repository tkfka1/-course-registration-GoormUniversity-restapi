package com.spring.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class OpenTimeEdit {

    @NotNull(message = "시작시간을 입력해주세요.")
    private LocalDateTime startTime;

    @NotNull(message = "종료시간을 입력해주세요.")
    private LocalDateTime endTime;

    @Builder
    public OpenTimeEdit(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
