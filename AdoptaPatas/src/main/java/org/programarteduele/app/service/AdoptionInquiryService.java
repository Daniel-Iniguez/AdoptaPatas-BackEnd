package org.programarteduele.app.service;

import java.util.List;

import org.programarteduele.app.entity.AdoptionInquiry;

public interface AdoptionInquiryService {
	
	  AdoptionInquiry createAdoptionInquiry(AdoptionInquiry inquiry, Long userId, Long petId);
	  AdoptionInquiry updateAdoptionInquiry(Long inquiryId, AdoptionInquiry updatedInquiry);
	  void deleteAdoptionInquiry(Long inquiryId);
	  AdoptionInquiry getAdoptionInquiryById(Long inquiryId);
	  List<AdoptionInquiry> getAllAdoptionInquiries();
	
}
