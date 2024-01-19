package org.programarteduele.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_likes")
public class PostLike {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_liker_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "liked_post_id")
    @JsonIgnore
    private Post post;
}
