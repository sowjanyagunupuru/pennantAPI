package com.example.PennantApI.DAO.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.PennantApI.DAO.Interface.SequenceDAOInterface;

@Repository
public class SequenceDAOImpl implements SequenceDAOInterface {

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(SequenceDAOImpl.class);

	@Override
	public long getNxtValue(String seqName) {
		logger.info("Entering UserDAOImpl to get the max userId");

		StringBuilder sql = new StringBuilder("SELECT nextval(:seqName)");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("seqName", seqName);

		try {
			long nextValue = jdbcTemplate.queryForObject(sql.toString(), paramMap, Long.class);
			logger.info("Leaving UserDAOImpl after getting a userId from the user table");
			return nextValue;

		} catch (Exception e) {

			logger.error("Error getting the next value from the sequence", e);
			throw new RuntimeException("Error getting the next value from the sequence", e);
		}
	}
}