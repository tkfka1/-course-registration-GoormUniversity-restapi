package com.spring.api.request;

import com.spring.api.domain.LectureClass;
import com.spring.api.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartLectureSignup {

    private LectureClass lectureClass;
    private User user;
    private Long credit;

}

