package org.programarteduele.app.controller;

import org.programarteduele.app.entity.PostLike;
import org.programarteduele.app.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/post-likes")
public class PostLikeController {

	 	@Autowired
	    private PostLikeService postLikeService;

	    @PostMapping("/{userId}/{postId}")
	    public ResponseEntity<PostLike> createPostLike(@PathVariable Long userId, @PathVariable Long postId) {
	        PostLike createdPostLike = postLikeService.createPostLike(userId, postId);
	        if (createdPostLike != null) {
	            return new ResponseEntity<>(createdPostLike, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{likeId}")
	    public ResponseEntity<Void> deletePostLike(@PathVariable Long likeId) {
	        postLikeService.deletePostLike(likeId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}