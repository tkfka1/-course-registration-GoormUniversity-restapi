package com.spring.api.repository;

import com.spring.api.domain.Lecture;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LectureRepository extends CrudRepository<Lecture, Long> , LectureRepositoryCustom{

    Optional<Lecture> findByName(String name);
}
