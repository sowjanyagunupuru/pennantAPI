package com.example.PennantApI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PennantApI.model.PartnerModel;
import com.example.PennantApI.service.Interface.PartnerServiceInterface;

@RestController
public class PartnerController {

	@Autowired
	private PartnerServiceInterface partnerServiceInterface;

	private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);

	/*
	 * 
	 */
	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/registerPartner", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> savePartner(@RequestBody PartnerModel user) {
		try {
			logger.info("In Partner controller to save the partner object");
			partnerServiceInterface.savePartner(user);
			logger.info("Leaving Partner controller after saving partner");
			return ResponseEntity.status(HttpStatus.OK).body("Successfully Added");
		} catch (DuplicateKeyException e) {
			logger.error("Error saving partner - Duplicate key violation", e);
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error saving user: Duplicate entry");
		} catch (Exception e) {
			logger.error("Error saving partner", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/checkPartner", method = RequestMethod.POST)
	public ResponseEntity<String> checkUsernameExists(@RequestParam String username) {
		try {
			logger.info("In User controller to check if username exists: {}", username);

			boolean usernameExists = partnerServiceInterface.checkUsernameExists(username);

			if (usernameExists) {
				logger.info("Username {} exists", username);
				return ResponseEntity.status(HttpStatus.OK).body("Username exists");
			} else {
				logger.info("Username {} does not exist", username);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username does not exist");
			}
		} catch (Exception e) {
			logger.error("Error checking username", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error checking username: " + e.getMessage());
		}
	}
}
