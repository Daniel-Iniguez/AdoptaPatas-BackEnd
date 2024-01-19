package org.programarteduele.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="user_post")
public class Post {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne // Muchas publicaciones pueden ser hechas por un usuario
	@JoinColumn(name = "user_author_id", referencedColumnName = "id", nullable=false)
	@JsonIgnoreProperties({"age", "email","phone","password","registrationDate","updatedAt","city","state","porfilePicture", 
		"bio","userType","following","followers","pets","adoptionInquiries"})
	private User user;
	@Column(name="content", columnDefinition="TINYTEXT")
	private String postContent;
	@Column(name="createdAt", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name="image", length=255)
	private String postImage;
	@Column(name="activo")
	private boolean active;
	
	
	@OneToMany(mappedBy = "post")
    private List<PostLike> postLikes;
	
    @OneToMany(mappedBy = "post")
    private List<Comment> postComments;

}
