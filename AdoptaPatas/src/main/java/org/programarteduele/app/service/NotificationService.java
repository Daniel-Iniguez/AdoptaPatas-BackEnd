package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.Notification;

public interface NotificationService {
	
    Notification createNotification(Notification notification, Long userId, Long typeId, Long sourceUserId, Long postId, Long commentId);
    Notification updateNotification(Long notificationId, Notification updatedNotification);
    void deleteNotification(Long notificationId);
    Notification getNotificationById(Long notificationId);
    List<Notification> getAllNotifications();

}
