package com.example.PennantApI.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.PennantApI.model.EmployeModel;

public class EmployeModelRowMapper implements RowMapper<EmployeModel> {
	@Override
	public EmployeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeModel employeModel = new EmployeModel();

		employeModel.setId(rs.getLong("id"));
		employeModel.setEmpId(rs.getString("emp_id"));
		employeModel.setFirstname(rs.getString("firstname"));
		employeModel.setLastname(rs.getString("lastname"));
		employeModel.setDob(rs.getDate("dob"));
		employeModel.setGender(rs.getString("gender"));
		employeModel.setContact1(rs.getString("contact1"));
		employeModel.setContact2(rs.getString("contact2"));
		employeModel.setEmail(rs.getString("email"));
		employeModel.setDomainMail(rs.getString("domain_mail"));
		employeModel.setAddress(rs.getString("address"));
		employeModel.setDesignation(rs.getString("designation"));
		employeModel.setUsername(rs.getString("username"));
		employeModel.setPassword(rs.getString("password"));
		employeModel.setJoiningDate(rs.getDate("joining_date"));
		employeModel.setSalary(rs.getDouble("salary"));
		employeModel.setManager(rs.getString("manager"));
		employeModel.setDepartment(rs.getString("department"));
		employeModel.setActive(rs.getBoolean("active"));

		return employeModel;
	}
}
