package com.spring.api.repository;

import com.spring.api.domain.Major;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MajorRepository extends CrudRepository<Major, Long> , MajorRepositoryCustom{

    Optional<Major> findByName(String name);
}
