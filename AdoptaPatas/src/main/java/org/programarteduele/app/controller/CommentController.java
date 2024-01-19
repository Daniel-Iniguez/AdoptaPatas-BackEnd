package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;
import org.programarteduele.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("adoptapatas/v1/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping
	ResponseEntity<Comment> setComment(@RequestBody Comment comment){
		Comment newComment = commentService.createComment(comment);
		return new ResponseEntity<>( newComment, HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity< List<Comment> > getAllComments(){
		List<Comment> comments = commentService.getAllComments();
		return new ResponseEntity<>( comments, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	Comment getCommentById(@PathVariable("id") Long id) {
		log.info("Se solicita los datos del id:" + id);
		Comment comment = commentService.getCommentById(id);
		return comment;
	}
	
	 @GetMapping("/post/{postId}")
	    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
	        return commentService.getCommentsByPostId(postId);
	    }

}
