package org.programarteduele.app.repository;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment> findByPostId(Long postId);
}
