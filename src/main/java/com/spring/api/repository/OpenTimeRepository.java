package com.spring.api.repository;

import com.spring.api.domain.OpenTime;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OpenTimeRepository extends CrudRepository<OpenTime, Long> , OpenTimeRepositoryCustom{

}
