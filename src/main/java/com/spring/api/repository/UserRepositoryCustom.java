package com.spring.api.repository;

import com.spring.api.domain.User;
import com.spring.api.request.UserSearch;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> getList(UserSearch UserSearch);
}
