package com.spring.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_student_id")
    private String studentId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_credit")
    private Long credit;
    @Column(name = "user_have_credit")
    @ColumnDefault("0")
    private Long haveCredit;
    @Column(name = "user_grade")
    @ColumnDefault("1")
    private Long grade;
    @Column(name = "user_created_date")
    private LocalDateTime createdDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Major major;

    @Builder
    public User(String studentId, String name, String email, String password, Long credit, Long haveCredit , Major major, Long grade) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.credit = credit;
        this.haveCredit = haveCredit;
        this.major = major;
        this.grade = grade;
        this.createdDate = LocalDateTime.now();
    }

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user" , fetch = FetchType.LAZY)
    private List<SessionUser> sessions = new ArrayList<>();

    public SessionUser addSession() {
        SessionUser session = SessionUser.builder()
                .user(this)
                .build();
        sessions.add(session);

        return session;
    }

    @JsonManagedReference(value = "user-takeLecture")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user" , fetch = FetchType.LAZY)
    private List<TakeLecture> TakeLectures  = new ArrayList<>();


    @JsonManagedReference(value = "user-cartLecture")
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user" , fetch = FetchType.LAZY)
    private List<CartLecture> CartLectures  = new ArrayList<>();

    public UserEditor.UserEditorBuilder toEditor() {
        return UserEditor.builder()
                .studentId(studentId)
                .name(name)
                .email(email)
                .password(password)
                .major(major)
                .credit(credit)
                .haveCredit(haveCredit)
                .grade(grade);
    }

    public void edit(UserEditor userEditor) {
        studentId = userEditor.getStudentId();
        name = userEditor.getName();
        email = userEditor.getEmail();
        password = userEditor.getPassword();
        major = userEditor.getMajor();
        credit = userEditor.getCredit();
        haveCredit = userEditor.getHaveCredit();
        grade = userEditor.getGrade();

    }
}
