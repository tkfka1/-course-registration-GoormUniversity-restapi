package com.spring.api.service;
import com.spring.api.crypto.PasswordEncoder;
import com.spring.api.domain.Admin;
import com.spring.api.domain.AdminEditor;
import com.spring.api.domain.User;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.AdminRepository;
import com.spring.api.request.AdminEdit;
import com.spring.api.request.AdminLogin;
import com.spring.api.exception.InvalidSigninInformation;
import com.spring.api.request.AdminSearch;
import com.spring.api.request.AdminSignup;
import com.spring.api.response.AdminResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;


    // 로그인
    @Transactional
    public Long signin(AdminLogin adminLogin) {
        Admin admin  = adminRepository.findByAdminId(adminLogin.getAdminId())
                .orElseThrow(InvalidSigninInformation::new);

        PasswordEncoder encoder = new PasswordEncoder();
        var matches = encoder.matches(adminLogin.getPassword(), admin.getPassword());
        if (!matches) {
            throw new InvalidSigninInformation();
        }

        return admin.getId();
    }


    // 회원가입
    public void signup(AdminSignup adminSignup) {
        Optional<Admin> adminOptional = adminRepository.findByAdminId(adminSignup.getAdminId());
        if (adminOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrpyt(adminSignup.getPassword());

        var admin = Admin.builder()
                .adminId(adminSignup.getAdminId())
                .password(encryptedPassword)
                .name(adminSignup.getName())
                .build();
        adminRepository.save(admin);
    }

    // 교직원 정보 조회
    public AdminResponse get(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return AdminResponse.builder()
                .id(admin.getId())
                .name(admin.getName())
                .adminId(admin.getAdminId())
                .build();
    }

    // 교직원 정보 조회 리스트
    public List<AdminResponse> getList(AdminSearch adminSearch) {
        return adminRepository.getList(adminSearch).stream()
                .map(AdminResponse::new)
                .collect(Collectors.toList());
    }


    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, AdminEdit adminEdit) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        AdminEditor.AdminEditorBuilder editorBuilder = admin.toEditor();

        PasswordEncoder encoder = new PasswordEncoder();
        String encryptedPassword = encoder.encrpyt(adminEdit.getPassword());

        AdminEditor adminEditor = editorBuilder
                .name(adminEdit.getName())
                .adminId(adminEdit.getAdminId())
                .password(encryptedPassword)
                .build();

        admin.edit(adminEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, AdminEdit adminEdit) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        AdminEditor.AdminEditorBuilder editorBuilder = admin.toEditor();

        AdminEditor adminEditor = editorBuilder
                .name(adminEdit.getName())
                .adminId(adminEdit.getAdminId())
                .build();

        admin.edit(adminEditor);
    }

    public void delete(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        adminRepository.delete(admin);
    }

}
