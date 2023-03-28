package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TakeLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "take_lecture_id")
    private Long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private LectureClass lectureClass;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    @Builder
    public TakeLecture(LectureClass lectureClass, User user) {
        this.lectureClass = lectureClass;
        this.user = user;
    }

    public TakeLectureEditor.TakeLectureEditorBuilder toEditor() {
        return TakeLectureEditor.builder()
                .lectureClass(lectureClass)
                .user(user);
    }

    public void edit(TakeLectureEditor TakelectureEditor) {
        lectureClass = TakelectureEditor.getLectureClass();
        user = TakelectureEditor.getUser();

    }

}
