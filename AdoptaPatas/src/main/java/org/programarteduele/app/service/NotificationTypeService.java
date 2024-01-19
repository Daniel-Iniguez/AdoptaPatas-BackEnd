package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.NotificationType;

public interface NotificationTypeService {
    NotificationType createNotificationType(NotificationType notificationType);
    NotificationType updateNotificationType(Long typeId, NotificationType updatedNotificationType);
    void deleteNotificationType(Long typeId);
    NotificationType getNotificationTypeById(Long typeId);
    List<NotificationType> getAllNotificationTypes();
}
