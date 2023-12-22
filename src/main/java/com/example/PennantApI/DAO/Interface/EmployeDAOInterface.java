package com.example.PennantApI.DAO.Interface;

import com.example.PennantApI.model.EmployeModel;

public interface EmployeDAOInterface {

	EmployeModel getEmployeeById(String id);

	public EmployeModel getEmployeeByUserName(String username);

}
