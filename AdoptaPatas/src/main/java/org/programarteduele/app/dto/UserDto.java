package org.programarteduele.app.dto;

import org.programarteduele.app.entity.Role;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
	
	private Long id;

	private String firstName;

	private String lastName;

	private String username;
	
	private String email;

	private int age;
	
	private String phone;
	
	private String bio;
	
	private String porfilePicture;
	
	private Role role;
}
