package com.example.PennantApI.service.Interface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.PennantApI.model.PartnerModel;

@Service
public interface PartnerServiceInterface {
	public ResponseEntity<String> savePartner(PartnerModel user);

	boolean checkUsernameExists(String username);
}
