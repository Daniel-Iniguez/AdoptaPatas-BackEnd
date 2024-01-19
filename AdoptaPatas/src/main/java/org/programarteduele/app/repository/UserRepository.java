package org.programarteduele.app.repository;

import java.util.Optional;

import org.programarteduele.app.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Iterable<User> findAllByActive(boolean state);
}