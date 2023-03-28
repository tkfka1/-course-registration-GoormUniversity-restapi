package com.spring.api.repository;

import com.spring.api.domain.TakeLecture;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TakeLectureRepository extends CrudRepository<TakeLecture, Long> , TakeLectureRepositoryCustom{

}
