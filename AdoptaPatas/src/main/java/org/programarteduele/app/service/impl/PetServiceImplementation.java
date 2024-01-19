package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.Pet;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.PetRepository;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImplementation implements PetService {
	
	   @Autowired
	    private PetRepository petRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public Pet createPet(Pet pet, Long userId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            pet.setUser(user);
	            
	            return petRepository.save(pet);
	        } else {
	            
	            return null;
	        }
	    }

	    @Override
	    public Pet updatePet(Long petId, Pet updatedPet) {
	        Optional<Pet> petOptional = petRepository.findById(petId);
	        if (petOptional.isPresent()) {
	            Pet existingPet = petOptional.get();
	            
	            
	            existingPet.setName(updatedPet.getName());
	            existingPet.setSize(updatedPet.getSize());
	            
	            return petRepository.save(existingPet);
	        } else {
	            
	            return null;
	        }
	    }

	    @Override
	    public void deletePet(Long petId) {
	        Optional<Pet> petOptional = petRepository.findById(petId);
	        petOptional.ifPresent(pet -> petRepository.delete(pet));
	        
	    }

	    @Override
	    public Pet getPetById(Long petId) {
	        return petRepository.findById(petId).orElse(null);
	    }

	    @Override
	    public List<Pet> getAllPets() {
	        return (List<Pet>) petRepository.findAll();
	    }


}
