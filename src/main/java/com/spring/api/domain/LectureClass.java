package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    @Column(name = "lecture_class_people")
    @ColumnDefault("0")
    private Long classPeople;
    @Column(name = "lecture_class_period")
    private Long period;
    @Column(name = "lecture_class_week")
    private Long week;
    @Column(name = "lecture_class_explanation")
    private String explanation;

    // 분반 > 강의 다대일
    @ManyToOne(fetch = FetchType.EAGER)
    private Lecture lecture;

    // 분반 > 교수 다대일
    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;


    @Builder
    public LectureClass(Long id, Long classMin, Long classMax, Long classPeople , Long period, Long week, String explanation, Lecture lecture, Professor professor) {
        this.id = id;
        this.classMin = classMin;
        this.classMax = classMax;
        this.classPeople = classPeople;
        this.period = period;
        this.week = week;
        this.explanation = explanation;
        this.lecture = lecture;
        this.professor = professor;
    }

    public LectureClassEditor.LectureClassEditorBuilder toEditor() {
        return LectureClassEditor.builder()
                .classMin(classMin)
                .classMax(classMax)
                .classPeople(classPeople)
                .period(period)
                .week(week)
                .explanation(explanation)
                .lecture(lecture)
                .professor(professor);

    }

    public void edit(LectureClassEditor lectureClassEditor) {
        this.classMin = lectureClassEditor.getClassMin();
        this.classMax = lectureClassEditor.getClassMax();
        this.classPeople = lectureClassEditor.getClassPeople();
        this.period = lectureClassEditor.getPeriod();
        this.week = lectureClassEditor.getWeek();
        this.explanation = lectureClassEditor.getExplanation();
        this.lecture = lectureClassEditor.getLecture();
        this.professor = lectureClassEditor.getProfessor();

    }


    // 수강신청 > 분반강의 다대일
    @JsonManagedReference(value = "lectureClass-takeLecture")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "lectureClass" , fetch = FetchType.LAZY)
    private List<TakeLecture> takeLectures  = new ArrayList<>();

    // 장바구니 > 분반강의 다대일
    @JsonManagedReference(value = "lectureClass-cartLecture")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "lectureClass" , fetch = FetchType.LAZY)
    private List<CartLecture> cartLectures  = new ArrayList<>();


}
