package com.spring.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LectureClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_class_id")
    private Long id;
    @Column(name = "lecture_class_min")
    private Long classMin;
    @Column(name = "lecture_class_max")
    private Long classMax;

    // 분반 > 강의 다대일
    @ManyToOne(fetch = FetchType.EAGER)
    private Lecture lecture;

    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;


    @Builder
    public LectureClass(Long id, Long classMin, Long classMax, Lecture lecture, Professor professor) {
        this.id = id;
        this.classMin = classMin;
        this.classMax = classMax;
        this.lecture = lecture;
        this.professor = professor;
    }

    public LectureClassEditor.LectureClassEditorBuilder toEditor() {
        return LectureClassEditor.builder()
                .classMin(classMin)
                .classMax(classMax)
                .lecture(lecture)
                .professor(professor);
    }

    public void edit(LectureClassEditor lectureClassEditor) {
        this.classMin = lectureClassEditor.getClassMin();
        this.classMax = lectureClassEditor.getClassMax();
        this.lecture = lectureClassEditor.getLecture();
        this.professor = lectureClassEditor.getProfessor();
    }

}
