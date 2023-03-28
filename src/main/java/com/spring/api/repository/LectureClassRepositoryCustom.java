package com.spring.api.repository;

import com.spring.api.domain.LectureClass;
import com.spring.api.request.LectureClassSearch;

import java.util.List;

public interface LectureClassRepositoryCustom {

    List<LectureClass> getList(LectureClassSearch LectureClassSearch);
}
