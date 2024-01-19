package org.programarteduele.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.programarteduele.app.dto.UserDto;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.service.UserDtoService;
import org.programarteduele.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoServiceImpl implements UserDtoService {
	
	@Autowired
	UserService userService;

	@Override
	public UserDto getUserById(Long id) {
		User user = userService.getUserById(id);		
		return userToUserDto(user);
	}

	@Override
	public UserDto getUserByEmail(String email) {		
		User user = userService.getUserByEmail(email);		
		return userToUserDto(user);
	}

	@Override
	public UserDto createUser(User user) {
		User newUser = userService.createUser(user);		
		return userToUserDto( newUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDto> usersDto = new ArrayList<>();
		for(User user : users ) {
			usersDto.add(   userToUserDto(user) );
		}
		return usersDto;
	}

	@Override
	public UserDto updateUser(User user, Long id) {
		User updatedUser = userService.updateUser(user, id);		
		return userToUserDto( updatedUser);
	}

	@Override
	public void deleteUser(Long id) {
		userService.deleteUser(id);		
	}
	
	private UserDto userToUserDto(User user ) {
		UserDto userDto = new UserDto();
		userDto.setId( user.getId() );
		userDto.setFirstName(  user.getFirstName() );
		userDto.setLastName(  user.getLastName() );
		userDto.setUsername(  user.getUsername() );
		userDto.setAge(  user.getAge() );
		userDto.setEmail( user.getEmail() );
		userDto.setPhone( user.getPhone() );
		userDto.setBio(user.getBio());
		userDto.setPorfilePicture(user.getPorfilePicture());
		userDto.setRole(user.getRole());
		return userDto;
	}

}
