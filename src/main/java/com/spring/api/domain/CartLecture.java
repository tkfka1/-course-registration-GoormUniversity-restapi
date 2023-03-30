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
public class CartLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @JsonBackReference(value = "lectureClass-cartLecture")
    @ManyToOne(fetch = FetchType.EAGER)
    private LectureClass lectureClass;
    @JsonBackReference(value = "user-cartLecture")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "cart_credit")
    private Long credit;

    @Column(name = "cart_date")
    private LocalDateTime takeDate;

    @Builder
    public CartLecture(LectureClass lectureClass, User user , Long credit) {
        this.lectureClass = lectureClass;
        this.user = user;
        this.takeDate = LocalDateTime.now();
        this.credit = credit;
    }

    public CartLectureEditor.CartLectureEditorBuilder toEditor() {
        return CartLectureEditor.builder()
                .lectureClass(lectureClass)
                .user(user)
                .credit(credit);
    }

    public void edit(CartLectureEditor cartLectureEditor) {
        lectureClass = cartLectureEditor.getLectureClass();
        user = cartLectureEditor.getUser();
        credit = cartLectureEditor.getCredit();

    }


}
