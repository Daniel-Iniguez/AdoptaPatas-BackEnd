package org.programarteduele.app.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_comment")
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "content")
    private String commentContent;

    @Column(name = "date_posted" , updatable = false)
    @CreationTimestamp
    private LocalDate date;
    
    //Muchos comentarios pueden ser hechos por un usuario
    @ManyToOne() 
    @JoinColumn(name = "comment_user_id")
    @JsonIgnoreProperties({"age", "email","phone","password","registrationDate","updatedAt","city","state","porfilePicture", 
		"bio","userType","following","followers","pets","adoptionInquiries"})
    private User user;

    //Muchos comentarios pueden ser hechos en una publicación 
    @ManyToOne() 
    @JoinColumn(name = "source_post_id")
    @JsonIgnoreProperties({"user","postContent", "createdAt", "postImage","postLikes", "postComments"})
    private Post post;

    // Un comentario puede tener muchos likes 
    @OneToMany(mappedBy = "comment")
    private List<CommentLike> commentLikes;


}
