package com.spring.api.repository;

import com.spring.api.domain.CartLecture;

import com.spring.api.domain.LectureClass;
import com.spring.api.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartLectureRepository extends CrudRepository<CartLecture, Long> , CartLectureRepositoryCustom{
    Optional<CartLecture> findByLectureClassAndUser(LectureClass lectureClass, User user);
}
