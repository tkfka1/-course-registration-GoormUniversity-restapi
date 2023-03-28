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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;
    @Column(name = "professor_name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Major major;

    @Builder
    public Professor(String name, Major major) {
        this.name = name;
        this.major = major;
    }

    public ProfessorEditor.ProfessorEditorBuilder toEditor() {
        return ProfessorEditor.builder()
                .name(name)
                .major(major);
    }

    public void edit(ProfessorEditor professorEditor) {
        name = professorEditor.getName();
        major = professorEditor.getMajor();
    }


    // 분반 > 교수 다대일
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "professor", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<LectureClass> lectureClassSessions = new ArrayList<>();

    public LectureClass addLectureClass() {
        LectureClass lectureClass = LectureClass.builder()
                .professor(this)
                .build();
        lectureClassSessions.add(lectureClass);

        return lectureClass;
    }

}
