package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;
    @Column(name = "lecture_name")
    private String name;
    @Column(name = "lecture_credit")
    private Long credit;
    @ManyToOne(fetch = FetchType.EAGER)
    private Major major;



    @Builder
    public Lecture(String name, Long credit, Major major) {
        this.name = name;
        this.credit = credit;
        this.major = major;
    }

    public LectureEditor.LectureEditorBuilder toEditor() {
        return LectureEditor.builder()
                .name(name)
                .credit(credit)
                .major(major);
    }

    public void edit(LectureEditor lectureEditor) {
        name = lectureEditor.getName();
        credit = lectureEditor.getCredit();
        major = lectureEditor.getMajor();
    }


    // 분반 > 강의 다대일
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "lecture" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LectureClass> lectureClasss = new ArrayList<>();




}
