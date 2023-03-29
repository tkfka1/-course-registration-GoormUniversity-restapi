package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @JsonBackReference(value = "lectureClass-takeLecture")
    @ManyToOne(fetch = FetchType.EAGER)
    private LectureClass lectureClass;
    @JsonBackReference(value = "user-takeLecture")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "take_credit")
    private Long credit;

    @Column(name = "take_date")
    private LocalDateTime takeDate;


    @Builder
    public TakeLecture(LectureClass lectureClass, User user , Long credit) {
        this.lectureClass = lectureClass;
        this.user = user;
        this.takeDate = LocalDateTime.now();
        this.credit = credit;
    }

    public TakeLectureEditor.TakeLectureEditorBuilder toEditor() {
        return TakeLectureEditor.builder()
                .lectureClass(lectureClass)
                .user(user)
                .credit(credit);
    }

    public void edit(TakeLectureEditor TakelectureEditor) {
        lectureClass = TakelectureEditor.getLectureClass();
        user = TakelectureEditor.getUser();
        credit = TakelectureEditor.getCredit();

    }

}
