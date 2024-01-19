package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.Pet;
import org.programarteduele.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/pets")
public class PetController {

	  @Autowired
	    private PetService petService;

	    @PostMapping("/{userId}")
	    public ResponseEntity<Pet> createPet(@RequestBody Pet pet, @PathVariable Long userId) {
	        Pet createdPet = petService.createPet(pet, userId);
	        if (createdPet != null) {
	            return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/{petId}")
	    public ResponseEntity<Pet> updatePet(@PathVariable Long petId, @RequestBody Pet updatedPet) {
	        Pet updatedPetResult = petService.updatePet(petId, updatedPet);
	        if (updatedPetResult != null) {
	            return new ResponseEntity<>(updatedPetResult, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{petId}")
	    public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
	        petService.deletePet(petId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/{petId}")
	    public ResponseEntity<Pet> getPetById(@PathVariable Long petId) {
	        Pet pet = petService.getPetById(petId);
	        if (pet != null) {
	            return new ResponseEntity<>(pet, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Pet>> getAllPets() {
	        List<Pet> pets = petService.getAllPets();
	        return new ResponseEntity<>(pets, HttpStatus.OK);
	    }
	    
    
}