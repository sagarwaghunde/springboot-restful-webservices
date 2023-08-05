package org.saga.springbootrestfulwebservices.repository;

import java.util.Optional;

import org.saga.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
