package com.example.PennantApI.DAO.Interface;

import org.springframework.stereotype.Repository;

@Repository
public interface SequenceDAOInterface {

	public long getNxtValue(String seqName);
}
