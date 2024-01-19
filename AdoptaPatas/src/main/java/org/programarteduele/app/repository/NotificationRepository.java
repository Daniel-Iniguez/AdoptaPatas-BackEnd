package org.programarteduele.app.repository;


import java.util.List;

import org.programarteduele.app.entity.Notification;
import org.programarteduele.app.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface NotificationRepository extends CrudRepository<Notification, Long>{
	List<Notification> findByUserAndIsReaded(User user, boolean isReaded);

}
