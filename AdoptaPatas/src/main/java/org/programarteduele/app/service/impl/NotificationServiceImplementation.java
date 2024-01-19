package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Notification;
import org.programarteduele.app.entity.NotificationType;
import org.programarteduele.app.entity.Post;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.CommentRepository;
import org.programarteduele.app.repository.NotificationRepository;
import org.programarteduele.app.repository.NotificationTypeRepository;
import org.programarteduele.app.repository.PostRepository;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImplementation implements NotificationService {

	 @Autowired
	    private NotificationRepository notificationRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private NotificationTypeRepository notificationTypeRepository;

	    @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private CommentRepository commentRepository;

	    @Override
	    public Notification createNotification(Notification notification, Long userId, Long typeId, Long sourceUserId, Long postId, Long commentId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        Optional<NotificationType> typeOptional = notificationTypeRepository.findById(typeId);
	        Optional<User> sourceUserOptional = userRepository.findById(sourceUserId);
	        Optional<Post> postOptional = postRepository.findById(postId);
	        Optional<Comment> commentOptional = commentRepository.findById(commentId);

	        if (userOptional.isPresent() && typeOptional.isPresent()) {
	            User user = userOptional.get();
	            NotificationType type = typeOptional.get();
	            notification.setUser(user);
	            notification.setType(type);

	            // Set source user, post, or comment based on the type of notification
	            if (type.getName().equals("Post Like") || type.getName().equals("Comment Like")) {
	                notification.setSourceUser(sourceUserOptional.orElse(null));
	            } else if (type.getName().equals("Post Comment")) {
	                notification.setPost(postOptional.orElse(null));
	            } else if (type.getName().equals("Comment Reply")) {
	                notification.setComment(commentOptional.orElse(null));
	            }
	            
	            return notificationRepository.save(notification);
	        } else {
	          
	            return null;
	        }
	    }

	    @Override
	    public Notification updateNotification(Long notificationId, Notification updatedNotification) {
	        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
	        if (notificationOptional.isPresent()) {
	            Notification existingNotification = notificationOptional.get();

	            existingNotification.setReaded(updatedNotification.isReaded());
	            
	            return notificationRepository.save(existingNotification);
	        } else {
	            
	            return null;
	        }
	    }

	    @Override
	    public void deleteNotification(Long notificationId) {
	        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
	        notificationOptional.ifPresent(notification -> notificationRepository.delete(notification));
	        
	    }

	    @Override
	    public Notification getNotificationById(Long notificationId) {
	        return notificationRepository.findById(notificationId).orElse(null);
	    }

	    @Override
	    public List<Notification> getAllNotifications() {
	        return (List<Notification>) notificationRepository.findAll();
	    }
	    

}
