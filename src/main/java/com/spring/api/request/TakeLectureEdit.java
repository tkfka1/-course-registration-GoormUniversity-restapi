package com.spring.api.request;


import com.spring.api.domain.LectureClass;
import com.spring.api.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class TakeLectureEdit {

    @NotNull(message = "이름을 입력해주세요.")
    private User user;
    @NotNull(message = "강의분반을 입력해주세요.")
    private LectureClass lectureClass;
    @Builder
    public TakeLectureEdit(User user, LectureClass lectureClass) {
        this.user = user;
        this.lectureClass = lectureClass;
    }

}
