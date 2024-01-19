package org.programarteduele.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.programarteduele.app.entity.AdoptionInquiry;
import org.programarteduele.app.entity.Pet;
import org.programarteduele.app.entity.User;
import org.programarteduele.app.repository.AdoptionInquiryRepository;
import org.programarteduele.app.repository.PetRepository;
import org.programarteduele.app.repository.UserRepository;
import org.programarteduele.app.service.AdoptionInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionInquiryServiceImplementation implements AdoptionInquiryService {
	
	 	@Autowired
	    private AdoptionInquiryRepository adoptionInquiryRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PetRepository petRepository;

	    @Override
	    public AdoptionInquiry createAdoptionInquiry(AdoptionInquiry inquiry, Long userId, Long petId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        Optional<Pet> petOptional = petRepository.findById(petId);

	        if (userOptional.isPresent() && petOptional.isPresent()) {
	            User user = userOptional.get();
	            Pet pet = petOptional.get();

	            inquiry.setUser(user);
	            inquiry.setPet(pet);
	            // Se puede agregar filtro
	            return adoptionInquiryRepository.save(inquiry);
	        } else {
	            // TODO manejar excepciones 
	            return null;
	        }
	    }

	    @Override
	    public AdoptionInquiry updateAdoptionInquiry(Long inquiryId, AdoptionInquiry updatedInquiry) {
	        Optional<AdoptionInquiry> inquiryOptional = adoptionInquiryRepository.findById(inquiryId);
	        if (inquiryOptional.isPresent()) {
	            AdoptionInquiry existingInquiry = inquiryOptional.get();
	            // Se pueden agregar filtros para actualizar campos especificos 
	            existingInquiry.setStatus(updatedInquiry.getStatus());
	            // Se pueden actualziar otros campos si es necesario
	            return adoptionInquiryRepository.save(existingInquiry);
	        } else {
	            // TODO manejo de excepciones
	            return null;
	        }
	    }

	    @Override
	    public void deleteAdoptionInquiry(Long inquiryId) {
	        Optional<AdoptionInquiry> inquiryOptional = adoptionInquiryRepository.findById(inquiryId);
	        inquiryOptional.ifPresent(inquiry -> adoptionInquiryRepository.delete(inquiry));
	        // Manejo de excepción si no sse encuentra la aplicación
	    }

	    @Override
	    public AdoptionInquiry getAdoptionInquiryById(Long inquiryId) {
	        return adoptionInquiryRepository.findById(inquiryId).orElse(null);
	    }

	    @Override
	    public List<AdoptionInquiry> getAllAdoptionInquiries() {
	        return (List<AdoptionInquiry>) adoptionInquiryRepository.findAll();
	    }
}
