package org.programarteduele.app.controller;

import java.util.List;

import org.programarteduele.app.entity.AdoptionInquiry;
import org.programarteduele.app.service.AdoptionInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adoptapatas/v1/adoption-inquiries")
public class AdoptionInquiryController {

    @Autowired
    private AdoptionInquiryService adoptionInquiryService;

    @PostMapping("/{userId}/{petId}")
    public ResponseEntity<AdoptionInquiry> createAdoptionInquiry(@RequestBody AdoptionInquiry inquiry,
                                                                 @PathVariable Long userId,
                                                                 @PathVariable Long petId) {
        AdoptionInquiry createdInquiry = adoptionInquiryService.createAdoptionInquiry(inquiry, userId, petId);
        if (createdInquiry != null) {
            return new ResponseEntity<>(createdInquiry, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{inquiryId}")
    public ResponseEntity<AdoptionInquiry> updateAdoptionInquiry(@PathVariable Long inquiryId,
                                                                 @RequestBody AdoptionInquiry updatedInquiry) {
        AdoptionInquiry updatedInquiryResult = adoptionInquiryService.updateAdoptionInquiry(inquiryId, updatedInquiry);
        if (updatedInquiryResult != null) {
            return new ResponseEntity<>(updatedInquiryResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{inquiryId}")
    public ResponseEntity<Void> deleteAdoptionInquiry(@PathVariable Long inquiryId) {
        adoptionInquiryService.deleteAdoptionInquiry(inquiryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{inquiryId}")
    public ResponseEntity<AdoptionInquiry> getAdoptionInquiryById(@PathVariable Long inquiryId) {
        AdoptionInquiry inquiry = adoptionInquiryService.getAdoptionInquiryById(inquiryId);
        if (inquiry != null) {
            return new ResponseEntity<>(inquiry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<AdoptionInquiry>> getAllAdoptionInquiries() {
        List<AdoptionInquiry> inquiries = adoptionInquiryService.getAllAdoptionInquiries();
        return new ResponseEntity<>(inquiries, HttpStatus.OK);
    }

}
