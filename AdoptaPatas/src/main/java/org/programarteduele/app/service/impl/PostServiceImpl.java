package org.programarteduele.app.service.impl;

import java.util.List;

import org.programarteduele.app.entity.Post;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.PostRepository;
import org.programarteduele.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Role does not exist with id " + id));
	}
	
	@Override
	public Post createPost(Post post) {
		post.setActive(true);
		return postRepository.save(post);
	}
	
	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = (List<Post>) postRepository.findAllByActive(true);
		return  posts;
	}

	@Override
	public Post updatePost(Post post, Long id) {
		Post existingPost = getPostById(id);
		existingPost.setPostContent( post.getPostContent() );
		existingPost.setPostImage( post.getPostImage() );
		return postRepository.save(existingPost);
	}
	
	
	@Override
	public void deletePost(Long id) {
		Post existingPost = getPostById(id);
		existingPost.setActive(false);
		postRepository.save(existingPost);		
	}
	

}
