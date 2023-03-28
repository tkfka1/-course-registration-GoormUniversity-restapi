package com.spring.api.service;

import com.spring.api.domain.Professor;
import com.spring.api.domain.ProfessorEditor;
import com.spring.api.exception.AlreadyExistsEmailException;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.ProfessorRepository;
import com.spring.api.request.*;
import com.spring.api.response.ProfessorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {


    private final ProfessorRepository professorRepository;


    // 회원가입
    public void signup(ProfessorSignup professorSignup) {
        Optional<Professor> professorOptional = professorRepository.findByName(professorSignup.getName());
        if (professorOptional.isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        var professor = Professor.builder()
                .name(professorSignup.getName())
                .major(professorSignup.getMajor())
                .build();
        professorRepository.save(professor);
    }

    // 전공 정보 조회
    public ProfessorResponse get(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return ProfessorResponse.builder()
                .id(professor.getId())
                .name(professor.getName())
                .major(professor.getMajor())
                .build();
    }
    // 학생 정보 조회 리스트
    public List<ProfessorResponse> getList(ProfessorSearch professorSearch) {
        return professorRepository.getList(professorSearch).stream()
                .map(ProfessorResponse::new)
                .collect(Collectors.toList());
    }


    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, ProfessorEdit professorEdit) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        ProfessorEditor.ProfessorEditorBuilder editorBuilder = professor.toEditor();

        ProfessorEditor professorEditor = editorBuilder
                .name(professorEdit.getName())
                .major(professorEdit.getMajor())
                .build();

        professor.edit(professorEditor);
    }

    // 비밀번호 없을 시
    @Transactional
    public void edit2(Long id, ProfessorEdit professorEdit) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        ProfessorEditor.ProfessorEditorBuilder editorBuilder = professor.toEditor();

        ProfessorEditor professorEditor = editorBuilder
                .name(professorEdit.getName())
                .major(professorEdit.getMajor())
                .build();

        professor.edit(professorEditor);
    }

    // 삭제
    public void delete(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        professorRepository.delete(professor);
    }

}
