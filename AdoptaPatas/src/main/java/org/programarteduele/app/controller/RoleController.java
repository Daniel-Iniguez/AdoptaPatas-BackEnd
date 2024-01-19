package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.Role;
import org.programarteduele.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("adoptapatas/v1/user-role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping
	ResponseEntity<Role> setRole(@RequestBody Role role){
		Role newRole = roleService.createRole(role);
		return new ResponseEntity<>( newRole, HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity< List<Role> > getAllRoles(){
		List<Role> roles = roleService.getAllRoles();
		return new ResponseEntity<>( roles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	Role getRoleById(@PathVariable("id") Long id) {
		log.info("Se solicita los datos del id:" + id);
		Role role = roleService.getRoleById(id);
		return role;
	}

}
