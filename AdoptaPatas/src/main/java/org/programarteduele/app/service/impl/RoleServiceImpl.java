package org.programarteduele.app.service.impl;

import java.util.List;

import org.programarteduele.app.entity.Role;
import org.programarteduele.app.repository.RoleRepository;
import org.programarteduele.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Role does not exist with id " + id));
	}
	
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public Role updateRole(Role role, Long id) {
		Role existingRole = getRoleById(id);
		existingRole.setName( role.getName() );
		existingRole.setDescription( role.getDescription() );
		return roleRepository.save(existingRole);
	}
	
	
	@Override
	public void deleteRole(Long id) {
		Role existingUser = getRoleById(id);
		roleRepository.delete(existingUser);		
	}
	

}
