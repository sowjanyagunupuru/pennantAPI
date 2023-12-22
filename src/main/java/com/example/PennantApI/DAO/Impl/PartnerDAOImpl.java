package com.example.PennantApI.DAO.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.PennantApI.DAO.Interface.PartnerDAOInterface;
import com.example.PennantApI.model.PartnerModel;

@Repository
public class PartnerDAOImpl implements PartnerDAOInterface {

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PartnerDAOImpl.class);

	/*
	 * save
	 */
	@Override
	public void save(PartnerModel user) {
		logger.info("ENTERING UserDAOImpl to save user object");

		StringBuilder insertQuery = new StringBuilder("INSERT INTO plf.partner ");
		insertQuery.append("(userid, name, username, contact, email, password, gender, active) ");
		insertQuery.append("VALUES (:userid, :name, :username, :contact, :email, :password, :gender, :active)");

		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		jdbcTemplate.update(insertQuery.toString(), param);

		logger.info("LEAVING UserDAOImpl after saving user object");

	}

	@Override
	public boolean checkUsernameExists(String username) {
		logger.info("ENTERING EmployeDAOImpl to check if username exists: {}", username);

		StringBuilder getSql = new StringBuilder("SELECT COUNT(*) FROM plf.partner WHERE username = :username");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("username", username);
		int count = this.jdbcTemplate.queryForObject(getSql.toString(), paramMap, Integer.class);
		boolean usernameExists = count > 0;

		// just to know output in the console with logger
		if (usernameExists) {
			logger.info("Username {} exists", username);
		} else {
			logger.info("Username {} does not exist", username);
		}

		logger.info("LEAVING EmployeDAOImpl");
		return usernameExists;
	}

}
