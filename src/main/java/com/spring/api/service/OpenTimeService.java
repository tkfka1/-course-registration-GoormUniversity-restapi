package com.spring.api.service;

import com.spring.api.domain.OpenTime;
import com.spring.api.domain.OpenTimeEditor;
import com.spring.api.exception.UserNotFound;
import com.spring.api.repository.OpenTimeRepository;
import com.spring.api.request.*;
import com.spring.api.response.OpenTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenTimeService {

    private final OpenTimeRepository openTimeRepository;


    // 시간등록
    public void signup(OpenTimeSignup openTimeSignup) {

        var openTime = OpenTime.builder()
                .startTime(openTimeSignup.getStartTime())
                .endTime(openTimeSignup.getEndTime())
                .build();
        openTimeRepository.save(openTime);
    }

    // 시간 정보 조회
    public OpenTimeResponse get(Long id) {
        OpenTime openTime = openTimeRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return OpenTimeResponse.builder()
                .id(openTime.getId())
                .startTime(openTime.getStartTime())
                .endTime(openTime.getEndTime())
                .build();
    }

    // 시간 정보 조회 리스트
    public List<OpenTimeResponse> getList(OpenTimeSearch openTimeSearch) {
        return openTimeRepository.getList(openTimeSearch).stream()
                .map(OpenTimeResponse::new)
                .collect(Collectors.toList());
    }


    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit(Long id, OpenTimeEdit openTimeEdit) {
        OpenTime openTime = openTimeRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        OpenTimeEditor.OpenTimeEditorBuilder editorBuilder = openTime.toEditor();

        OpenTimeEditor openTimeEditor = editorBuilder
                .startTime(openTimeEdit.getStartTime())
                .endTime(openTimeEdit.getEndTime())
                .build();

        openTime.edit(openTimeEditor);
    }

    // 비밀번호 있을 시 업데이트
    @Transactional
    public void edit2(Long id, OpenTimeEdit openTimeEdit) {
        OpenTime openTime = openTimeRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        OpenTimeEditor.OpenTimeEditorBuilder editorBuilder = openTime.toEditor();

        OpenTimeEditor openTimeEditor = editorBuilder
                .startTime(openTimeEdit.getStartTime())
                .endTime(openTimeEdit.getEndTime())
                .build();

        openTime.edit(openTimeEditor);
    }

    public void delete(Long id) {
        OpenTime openTime = openTimeRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        openTimeRepository.delete(openTime);
    }

}
