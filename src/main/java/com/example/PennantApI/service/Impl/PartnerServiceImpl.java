package com.example.PennantApI.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.PennantApI.DAO.Interface.PartnerDAOInterface;
import com.example.PennantApI.DAO.Interface.SequenceDAOInterface;
import com.example.PennantApI.model.PartnerModel;
import com.example.PennantApI.service.Interface.PartnerServiceInterface;

@Service
public class PartnerServiceImpl implements PartnerServiceInterface {
	@Autowired
	private PartnerDAOInterface partnerDAOInterface;
	@Autowired
	private SequenceDAOInterface sequence;
	private static final Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);

	@Override
	public ResponseEntity<String> savePartner(PartnerModel partner) {
		logger.info("ENTERING PartnerServiceImpl to save the user");

		partner.setActive(true);
		long id = sequence.getNxtValue("seq_partners");
		partner.setUserid(id);
		partnerDAOInterface.save(partner);
		logger.info("LEAVING PartnerServiceImpl after saving the user");
		return new ResponseEntity<>("User saved successfully", HttpStatus.OK);

	}

	@Override
	public boolean checkUsernameExists(String username) {
		return partnerDAOInterface.checkUsernameExists(username);
	}
}
