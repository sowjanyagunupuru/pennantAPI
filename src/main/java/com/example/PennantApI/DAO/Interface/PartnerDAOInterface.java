package com.example.PennantApI.DAO.Interface;

import org.springframework.stereotype.Repository;

import com.example.PennantApI.model.PartnerModel;

@Repository
public interface PartnerDAOInterface {

	public void save(PartnerModel user);

	public boolean checkUsernameExists(String username);

}
