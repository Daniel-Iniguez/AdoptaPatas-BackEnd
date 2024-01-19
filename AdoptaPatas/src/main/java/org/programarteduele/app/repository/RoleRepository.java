package org.programarteduele.app.repository;

import java.util.Optional;

import org.programarteduele.app.entity.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long>{
	Optional<Role> findByName(String name);

}
