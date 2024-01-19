package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Indica que es un componente pero pertenece a la capa de servicio
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if( userOptional.isPresent()) return userOptional.get();
		else throw new IllegalStateException("User does not exist");
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> existingUser = userRepository.findByEmail(email);
		if( existingUser.isPresent()) return existingUser.get();
		else throw new IllegalStateException("User does not exist with email " + email);
	}

	@Override
	public User createUser(User user) {
		user.setId(null);
		user.setActive(true);
		//TODO Verificar que no exista el email.
		
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAllByActive(true);
		return users;
	}

	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserById(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setAge(user.getAge());
		existingUser.setPhone(user.getPhone());
		existingUser.setBio(user.getBio());
		existingUser.setPorfilePicture(user.getPorfilePicture());
		// Si modificamos el email, se debe verificar que no exista.
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		//userRepository.delete(existingUser);
		existingUser.setActive(false);
		userRepository.save(existingUser);
	}

}
