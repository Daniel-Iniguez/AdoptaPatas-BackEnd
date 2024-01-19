package org.programarteduele.app.repository;

import java.util.Optional;

import org.programarteduele.app.entity.NotificationType;
import org.springframework.data.repository.CrudRepository;


public interface NotificationTypeRepository extends CrudRepository<NotificationType, Long>{
	Optional<NotificationType> findByName(String name);

}
