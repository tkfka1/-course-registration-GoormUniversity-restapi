package com.spring.api.repository;


import com.spring.api.domain.Professor;
import com.spring.api.request.ProfessorSearch;

import java.util.List;

public interface ProfessorRepositoryCustom {

    List<Professor> getList(ProfessorSearch ProfessorSearch);
}
