package com.spring.api.repository;

import com.spring.api.domain.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessorRepository extends CrudRepository<Professor, Long> , ProfessorRepositoryCustom{

    Optional<Professor> findByName(String name);
}
