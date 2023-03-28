package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Long id;
    @Column(name = "major_name")
    private String name;


    @Builder
    public Major(String name) {
        this.name = name;
    }



    public MajorEditor.MajorEditorBuilder toEditor() {
        return MajorEditor.builder()
                .name(name);
    }

    public void edit(MajorEditor majorEditor) {
        name = majorEditor.getName();
    }


    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Lecture> sessions1 = new ArrayList<>();

    public Lecture addLecture() {
        Lecture lecture = Lecture.builder()
                .major(this)
                .build();
        sessions1.add(lecture);

        return lecture;
    }

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Professor> sessions2 = new ArrayList<>();
    public Professor addProfessor() {
        Professor professor = Professor.builder()
                .major(this)
                .build();
        sessions2.add(professor);

        return professor;
    }

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "major", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> sessions3 = new ArrayList<>();

    public User addUser() {
        User user = User.builder()
                .major(this)
                .build();
        sessions3.add(user);

        return user;
    }

}
