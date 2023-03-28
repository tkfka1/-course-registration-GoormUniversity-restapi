package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.Admin;
import com.spring.api.request.AdminSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QAdmin.admin;

@RequiredArgsConstructor
public class AdminRepositoryImpl implements AdminRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Admin> getList(AdminSearch userSearch) {
        return jpaQueryFactory.selectFrom(admin)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(admin.id.desc())
                .fetch();
    }
}
