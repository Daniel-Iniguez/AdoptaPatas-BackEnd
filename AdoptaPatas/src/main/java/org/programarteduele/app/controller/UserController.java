package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.User;
import org.programarteduele.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("adoptapatas/v1/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	List<User> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	@GetMapping("{id}")
	User getUserById( @PathVariable("id") Long id ) {
		log.info("Se solicita los datos del id: " + id);
		User user = userService.getUserById(id);
		//User user = new User();
		return user;
	}
	
	@PostMapping
	User setUser(@RequestBody User user ) {
		log.info("Se esta creando un usuario");
		log.info(user);
		User newUser = userService.createUser(user);
		return newUser;
	}
	
	@GetMapping("query") // localhost:8080/adoptapatas/v1/users/query?email=jose@gmail.com
	User getUserByEmail(@RequestParam(name="email") String email) {
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("{id}")
	User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("{id}")
	String deleteUser(@PathVariable("id") Long id ) {
		userService.deleteUser(id);
		return "Se eliminó el usuario id " + id;
	}
	
	
	
}
