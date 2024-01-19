package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.Notification;
import org.programarteduele.app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/{userId}/{typeId}/{sourceUserId}/{postId}/{commentId}")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification,
                                                           @PathVariable Long userId,
                                                           @PathVariable Long typeId,
                                                           @PathVariable Long sourceUserId,
                                                           @PathVariable Long postId,
                                                           @PathVariable Long commentId) {
        Notification createdNotification = notificationService.createNotification(
                notification, userId, typeId, sourceUserId, postId, commentId);

        if (createdNotification != null) {
            return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{notificationId}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long notificationId,
                                                           @RequestBody Notification updatedNotification) {
        Notification updatedNotificationResult = notificationService.updateNotification(
                notificationId, updatedNotification);

        if (updatedNotificationResult != null) {
            return new ResponseEntity<>(updatedNotificationResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notificationId) {
        Notification notification = notificationService.getNotificationById(notificationId);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
    
}
