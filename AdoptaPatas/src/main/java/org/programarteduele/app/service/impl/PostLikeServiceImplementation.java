package org.programarteduele.app.service.impl;

import java.util.Optional;

import org.programarteduele.app.entity.Post;
import org.programarteduele.app.entity.PostLike;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.PostLikeRepository;
import org.programarteduele.app.repository.PostRepository;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLikeServiceImplementation implements PostLikeService{
	
	 @Autowired
	    private PostLikeRepository postLikeRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PostRepository postRepository;

	    @Override
	    public PostLike createPostLike(Long userId, Long postId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        Optional<Post> postOptional = postRepository.findById(postId);

	        if (userOptional.isPresent() && postOptional.isPresent()) {
	            User user = userOptional.get();
	            Post post = postOptional.get();

	            PostLike postLike = new PostLike();
	            postLike.setUser(user);
	            postLike.setPost(post);
	            
	            return postLikeRepository.save(postLike);
	        } else {
	            
	            return null;
	        }
	    }

	    @Override
	    public void deletePostLike(Long likeId) {
	        postLikeRepository.deleteById(likeId);
	        
	    }
}
