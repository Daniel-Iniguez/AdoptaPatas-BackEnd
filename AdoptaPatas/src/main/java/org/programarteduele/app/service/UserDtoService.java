package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.dto.UserDto;
import org.programarteduele.app.entity.User;

public interface UserDtoService {
	
	UserDto getUserById(Long id);
	UserDto getUserByEmail(String email);
	UserDto createUser(User user);
	List<UserDto> getAllUsers();
	UserDto updateUser(User user, Long id);
	void deleteUser(Long id);

}
