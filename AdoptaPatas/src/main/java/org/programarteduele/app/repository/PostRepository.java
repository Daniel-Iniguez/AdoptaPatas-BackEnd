package org.programarteduele.app.repository;

import java.util.List;

import org.programarteduele.app.entity.Comment;
import org.programarteduele.app.entity.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long>{
	Iterable<Post> findAllByActive(boolean state);
	List<Post> findByUserId(Long userId);

}
