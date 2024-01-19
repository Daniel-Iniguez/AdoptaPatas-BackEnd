package org.programarteduele.app.service;

import org.programarteduele.app.entity.CommentLike;

public interface CommentLikeService {

    CommentLike createCommentLike(Long userId, Long commentId);
    void deleteCommentLike(Long likeId);
    
}
