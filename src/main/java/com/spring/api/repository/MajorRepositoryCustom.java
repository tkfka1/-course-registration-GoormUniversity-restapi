package com.spring.api.repository;


import com.spring.api.domain.Major;
import com.spring.api.request.MajorSearch;

import java.util.List;

public interface MajorRepositoryCustom {

    List<Major> getList(MajorSearch MajorSearch);
}
