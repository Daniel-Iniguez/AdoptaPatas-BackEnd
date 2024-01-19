package org.programarteduele.app.service.impl;

import java.util.Optional;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.CommentLike;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.CommentLikeRepository;
import org.programarteduele.app.repository.CommentRepository;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikeServiceImplementation implements CommentLikeService {
	
	 	@Autowired
	    private CommentLikeRepository commentLikeRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private CommentRepository commentRepository;

	    @Override
	    public CommentLike createCommentLike(Long userId, Long commentId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        Optional<Comment> commentOptional = commentRepository.findById(commentId);

	        if (userOptional.isPresent() && commentOptional.isPresent()) {
	            User user = userOptional.get();
	            Comment comment = commentOptional.get();

	            CommentLike commentLike = new CommentLike();
	            commentLike.setUser(user);
	            commentLike.setComment(comment);
	            // Se puede agregar filtro para creación de like, no hace falta
	            return commentLikeRepository.save(commentLike);
	        } else {
	            // TODO manejo excepción
	            return null;
	        }
	    }

	    @Override
	    public void deleteCommentLike(Long likeId) {
	        commentLikeRepository.deleteById(likeId);
	        // TODO manejo de excepción, no encontrado
	    }

}
