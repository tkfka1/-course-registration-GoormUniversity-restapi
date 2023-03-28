package com.spring.api.repository;

import com.spring.api.domain.TakeLecture;
import com.spring.api.request.TakeLectureSearch;

import java.util.List;

public interface TakeLectureRepositoryCustom {

    List<TakeLecture> getList(TakeLectureSearch TakeLectureSearch);
}
