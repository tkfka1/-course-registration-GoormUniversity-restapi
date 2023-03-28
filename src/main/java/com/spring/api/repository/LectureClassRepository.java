package com.spring.api.repository;


import com.spring.api.domain.LectureClass;
import com.spring.api.domain.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LectureClassRepository extends CrudRepository<LectureClass, Long> , LectureClassRepositoryCustom{

    Optional<LectureClass> findById(Long id);
    Optional<LectureClass> findByProfessor(Professor professor);
    Optional<LectureClass> findByPeriod(Long period);
    Optional<LectureClass> findByWeek(Long week);
}
