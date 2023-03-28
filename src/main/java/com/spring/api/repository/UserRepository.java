package com.spring.api.repository;

import com.spring.api.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> , UserRepositoryCustom{

    Optional<User> findByStudentId(String studentId);

}
