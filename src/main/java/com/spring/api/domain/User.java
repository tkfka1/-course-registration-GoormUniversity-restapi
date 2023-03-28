package com.spring.api.domain;

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
    @Column(name = "user_created_date")
    private LocalDateTime createdDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Major major;

    @Builder
    public User(String studentId, String name, String email, String password, Long credit, Major major) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.credit = credit;
        this.major = major;
        this.createdDate = LocalDateTime.now();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<SessionUser> sessions = new ArrayList<>();

    public SessionUser addSession() {
        SessionUser session = SessionUser.builder()
                .user(this)
                .build();
        sessions.add(session);

        return session;
    }


    public UserEditor.UserEditorBuilder toEditor() {
        return UserEditor.builder()
                .studentId(studentId)
                .name(name)
                .email(email)
                .password(password)
                .major(major)
                .credit(credit);
    }

    public void edit(UserEditor userEditor) {
        studentId = userEditor.getStudentId();
        name = userEditor.getName();
        email = userEditor.getEmail();
        password = userEditor.getPassword();
        major = userEditor.getMajor();
        credit = userEditor.getCredit();


    }
}
