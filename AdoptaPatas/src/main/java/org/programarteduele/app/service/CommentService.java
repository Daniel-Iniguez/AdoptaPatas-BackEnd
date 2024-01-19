package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;

public interface CommentService {
	
	Comment getCommentById(Long id);
	Comment createComment(Comment comment);
	List<Comment> getAllComments();
	List<Comment> getCommentsByPostId(Long postId);
	Comment updateComment(Comment comment, Long id);
	void deleteComment(Long id);

}
