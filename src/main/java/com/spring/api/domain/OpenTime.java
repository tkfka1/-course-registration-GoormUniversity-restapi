package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;


    @Builder
    public OpenTime( LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public OpenTimeEditor.OpenTimeEditorBuilder toEditor() {
        return OpenTimeEditor.builder()
                .startTime(startTime)
                .endTime(endTime);
    }

    public void edit(OpenTimeEditor openTimeEditor) {
        startTime = openTimeEditor.getStartTime();
        endTime = openTimeEditor.getEndTime();
    }


}
