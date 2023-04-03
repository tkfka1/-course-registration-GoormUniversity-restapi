package com.spring.api.repository;


import com.spring.api.domain.OpenTime;
import com.spring.api.request.OpenTimeSearch;

import java.util.List;

public interface OpenTimeRepositoryCustom {

    List<OpenTime> getList(OpenTimeSearch OpenTimeSearch);
}
