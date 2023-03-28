package com.spring.api.repository;


import com.spring.api.domain.Lecture;
import com.spring.api.request.LectureSearch;

import java.util.List;

public interface LectureRepositoryCustom {

    List<Lecture> getList(LectureSearch LectureSearch);
}
