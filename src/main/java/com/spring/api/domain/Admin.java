package com.spring.api.domain;

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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;
    @Column(name = "admin_admin_id")
    private String adminId;
    @Column(name = "admin_name")
    private String name;
    @Column(name = "admin_password")
    private String password;

    @Builder
    public Admin(String adminId, String name, String password) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SessionAdmin> sessions = new ArrayList<>();

    public SessionAdmin addSession() {
        SessionAdmin session = SessionAdmin.builder()
                .admin(this)
                .build();
        sessions.add(session);

        return session;
    }

    public AdminEditor.AdminEditorBuilder toEditor() {
        return AdminEditor.builder()
                .adminId(adminId)
                .name(name)
                .password(password);
    }

    public void edit(AdminEditor userEditor) {
        adminId = userEditor.getAdminId();
        name = userEditor.getName();
        password = userEditor.getPassword();
    }

}
