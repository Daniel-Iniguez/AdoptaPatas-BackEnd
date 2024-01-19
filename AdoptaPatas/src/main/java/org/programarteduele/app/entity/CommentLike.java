package org.programarteduele.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "comment_likes")
public class CommentLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "liked_comment_id")
	private Comment comment;

	@ManyToOne()
	@JoinColumn(name = "comment_liker_user_id")
	private User user;
}
