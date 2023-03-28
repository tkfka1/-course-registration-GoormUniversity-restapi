package com.spring.api.repository;

import com.spring.api.domain.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> , AdminRepositoryCustom{

    Optional<Admin> findByAdminId(String adminId);

}
