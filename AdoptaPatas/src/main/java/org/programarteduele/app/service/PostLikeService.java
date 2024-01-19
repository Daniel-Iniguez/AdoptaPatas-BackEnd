package org.programarteduele.app.service;

import org.programarteduele.app.entity.PostLike;

public interface PostLikeService {
	
    PostLike createPostLike(Long userId, Long postId);
    void deletePostLike(Long likeId);

}
