package org.programarteduele.app.controller;

import org.programarteduele.app.entity.CommentLike;
import org.programarteduele.app.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/comment-likes")
public class CommentLikeController {

	@Autowired
	private CommentLikeService commentLikeService;

	@PostMapping("/{userId}/{commentId}")
	public ResponseEntity<CommentLike> createCommentLike(@PathVariable Long userId, @PathVariable Long commentId) {
		CommentLike createdCommentLike = commentLikeService.createCommentLike(userId, commentId);
		if (createdCommentLike != null) {
			return new ResponseEntity<>(createdCommentLike, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{likeId}")
	public ResponseEntity<Void> deleteCommentLike(@PathVariable Long likeId) {
		commentLikeService.deleteCommentLike(likeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
