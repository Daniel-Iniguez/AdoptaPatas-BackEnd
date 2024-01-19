package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("adoptapatas/v1/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping
	ResponseEntity<Post> setRole(@RequestBody Post role){
		Post newRole = postService.createPost(role);
		return new ResponseEntity<>( newRole, HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity< List<Post> > getAllRoles(){
		List<Post> roles = postService.getAllPosts();
		return new ResponseEntity<>( roles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	Post getRoleById(@PathVariable("id") Long id) {
		log.info("Se solicita los datos del id:" + id);
		Post role = postService.getPostById(id);
		return role;
	}
	
	@PutMapping("{id}")
	Post updatePost(@RequestBody Post post, @PathVariable("id") Long id) {
		return postService.updatePost(post, id);
	}
	
	@DeleteMapping("{id}")
	String deleteUser(@PathVariable("id") Long id ) {
		postService.deletePost(id);
		return "Se eliminó el usuario id " + id;
	}
	
	@GetMapping("/user-post/{userId}")
    public List<Post> getCommentsByPostId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

}
