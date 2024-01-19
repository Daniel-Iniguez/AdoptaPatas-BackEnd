package org.programarteduele.app.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentDto {
	
	 	private Long id;
	    private String commentContent;
	    private LocalDateTime date;
	    private UserDto user;
	    private PostDto post;
}
