package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;
import org.programarteduele.app.repository.CommentRepository;
import org.programarteduele.app.repository.PostRepository;
import org.programarteduele.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	

	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Comment does not exist with id " + id));
	}
	
	@Override
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	@Override
	public List<Comment> getAllComments() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment updateComment(Comment comment, Long id) {
		Comment existingComment = getCommentById(id);
		existingComment.setCommentContent( comment.getCommentContent() );
		return commentRepository.save(existingComment);
	}
	
	
	@Override
	public void deleteComment(Long id) {
		Comment existingComment = getCommentById(id);
		commentRepository.delete(existingComment);		
	}
	
	@Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }


}
