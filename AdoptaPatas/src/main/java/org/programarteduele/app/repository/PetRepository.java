package org.programarteduele.app.repository;

import java.util.List;

import org.programarteduele.app.entity.Pet;
import org.programarteduele.app.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface PetRepository extends CrudRepository<Pet, Long>{
      
	List<Pet> findByUser(User user);
}
