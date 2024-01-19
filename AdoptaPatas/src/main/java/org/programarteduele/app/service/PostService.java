package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.Post;

public interface PostService {
	
	Post getPostById(Long id);
	Post createPost(Post role);
	List<Post> getAllPosts();
	Post updatePost(Post post, Long id);
	void deletePost(Long id);

}
