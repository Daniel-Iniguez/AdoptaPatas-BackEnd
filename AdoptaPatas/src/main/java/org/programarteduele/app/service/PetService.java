package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.Pet;

public interface PetService {
	
    Pet createPet(Pet pet, Long userId);
    Pet updatePet(Long petId, Pet updatedPet);
    void deletePet(Long petId);
    Pet getPetById(Long petId);
    List<Pet> getAllPets();
}
