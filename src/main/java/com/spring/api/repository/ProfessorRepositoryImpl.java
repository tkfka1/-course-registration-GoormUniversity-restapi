package com.spring.api.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.api.domain.Professor;
import com.spring.api.request.ProfessorSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.spring.api.domain.QProfessor.professor;

@RequiredArgsConstructor
public class ProfessorRepositoryImpl implements ProfessorRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Professor> getList(ProfessorSearch professorSearch) {
        return jpaQueryFactory.selectFrom(professor)
//                .limit(userSearch.getSize())
//                .offset(userSearch.getOffset())
                .orderBy(professor.id.desc())
                .fetch();
    }
}
