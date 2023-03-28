package com.spring.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


}
