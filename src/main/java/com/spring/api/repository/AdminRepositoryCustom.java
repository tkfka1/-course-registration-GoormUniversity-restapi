package com.spring.api.repository;

import com.spring.api.domain.Admin;
import com.spring.api.request.AdminSearch;

import java.util.List;

public interface AdminRepositoryCustom {

    List<Admin> getList(AdminSearch AdminSearch);
}
