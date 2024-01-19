package org.programarteduele.app.dto;

import java.time.LocalDateTime;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDto {
	
    private Long id;
    private UserDto user;
    private String postContent;
    private LocalDateTime createdAt;
    private String postImage;

}
