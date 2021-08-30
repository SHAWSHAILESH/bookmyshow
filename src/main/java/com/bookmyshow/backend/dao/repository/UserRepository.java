package com.bookmyshow.backend.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.backend.dao.models.UserDao;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Long> {
	UserDao findByName(String name);
}
