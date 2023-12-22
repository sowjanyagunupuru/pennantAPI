package com.example.PennantApI.DAO.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.PennantApI.DAO.Interface.EmployeDAOInterface;
import com.example.PennantApI.model.EmployeModel;

@Repository
public class EmployeDAOImpl implements EmployeDAOInterface {

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(EmployeDAOImpl.class);

	@Override
	public EmployeModel getEmployeeById(String empId) {

		StringBuilder getSql = new StringBuilder("select * FROM plf.Employee WHERE empId = :empId");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("empId", empId);
		EmployeModel employe = this.jdbcTemplate.queryForObject(getSql.toString(), paramMap,
				new BeanPropertyRowMapper<>(EmployeModel.class));
		logger.debug("LEAVING EmployeDAOImpl");
		return employe;

	}

	@Override
	public EmployeModel getEmployeeByUserName(String username) {

		StringBuilder getSql = new StringBuilder("select * FROM plf.Employee WHERE username = :username");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("username", username);
		EmployeModel employe = this.jdbcTemplate.queryForObject(getSql.toString(), paramMap,
				new BeanPropertyRowMapper<>(EmployeModel.class));
		logger.debug("LEAVING EmployeDAOImpl");
		return employe;

	}
}
