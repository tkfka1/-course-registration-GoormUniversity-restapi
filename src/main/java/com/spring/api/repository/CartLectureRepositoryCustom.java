package com.spring.api.repository;


import com.spring.api.domain.CartLecture;
import com.spring.api.request.CartLectureSearch;

import java.util.List;

public interface CartLectureRepositoryCustom {

    List<CartLecture> getList(CartLectureSearch cartLectureSearch);
}
