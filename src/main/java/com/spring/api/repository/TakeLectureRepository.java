package com.spring.api.repository;

import com.spring.api.domain.LectureClass;
import com.spring.api.domain.TakeLecture;
import com.spring.api.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TakeLectureRepository extends CrudRepository<TakeLecture, Long> , TakeLectureRepositoryCustom{

    Optional<TakeLecture> findByLectureClassAndUser(LectureClass lectureClass, User user);
}
