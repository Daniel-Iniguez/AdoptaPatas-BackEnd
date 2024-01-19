package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.NotificationType;
import org.programarteduele.app.service.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/notification-types")
public class NotificationTypeController {

    @Autowired
    private NotificationTypeService notificationTypeService;

    @PostMapping
    public ResponseEntity<NotificationType> createNotificationType(@RequestBody NotificationType notificationType) {
        NotificationType createdNotificationType = notificationTypeService.createNotificationType(notificationType);
        return new ResponseEntity<>(createdNotificationType, HttpStatus.CREATED);
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<NotificationType> updateNotificationType(@PathVariable Long typeId,
                                                                   @RequestBody NotificationType updatedNotificationType) {
        NotificationType updatedTypeResult = notificationTypeService.updateNotificationType(typeId, updatedNotificationType);
        if (updatedTypeResult != null) {
            return new ResponseEntity<>(updatedTypeResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<Void> deleteNotificationType(@PathVariable Long typeId) {
        notificationTypeService.deleteNotificationType(typeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<NotificationType> getNotificationTypeById(@PathVariable Long typeId) {
        NotificationType notificationType = notificationTypeService.getNotificationTypeById(typeId);
        if (notificationType != null) {
            return new ResponseEntity<>(notificationType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<NotificationType>> getAllNotificationTypes() {
        List<NotificationType> notificationTypes = notificationTypeService.getAllNotificationTypes();
        return new ResponseEntity<>(notificationTypes, HttpStatus.OK);
    }
    
}
