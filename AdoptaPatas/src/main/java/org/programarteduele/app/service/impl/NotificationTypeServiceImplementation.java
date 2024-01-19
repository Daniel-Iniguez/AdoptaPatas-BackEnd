package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.NotificationType;
import org.programarteduele.app.repository.NotificationTypeRepository;
import org.programarteduele.app.service.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationTypeServiceImplementation implements NotificationTypeService {

    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Override
    public NotificationType createNotificationType(NotificationType notificationType) {
        
        return notificationTypeRepository.save(notificationType);
    }

    @Override
    public NotificationType updateNotificationType(Long typeId, NotificationType updatedNotificationType) {
        Optional<NotificationType> notificationTypeOptional = notificationTypeRepository.findById(typeId);
        if (notificationTypeOptional.isPresent()) {
            NotificationType existingNotificationType = notificationTypeOptional.get();
            
            
            existingNotificationType.setName(updatedNotificationType.getName());
            existingNotificationType.setDescription(updatedNotificationType.getDescription());
            existingNotificationType.setRedirectUrl(updatedNotificationType.getRedirectUrl());
            
            return notificationTypeRepository.save(existingNotificationType);
        } else {
            
            return null;
        }
    }

    @Override
    public void deleteNotificationType(Long typeId) {
        notificationTypeRepository.deleteById(typeId);
        
    }

    @Override
    public NotificationType getNotificationTypeById(Long typeId) {
        return notificationTypeRepository.findById(typeId).orElse(null);
    }

    @Override
    public List<NotificationType> getAllNotificationTypes() {
        return (List<NotificationType>) notificationTypeRepository.findAll();
    }
    
}
