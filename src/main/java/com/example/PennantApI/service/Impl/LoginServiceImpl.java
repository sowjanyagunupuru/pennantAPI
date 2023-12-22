package com.example.PennantApI.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PennantApI.DAO.Interface.EmployeDAOInterface;
import com.example.PennantApI.model.EmployeModel;
import com.example.PennantApI.model.LoginModel;
import com.example.PennantApI.service.Interface.LoginServiceInterface;

@Service
public class LoginServiceImpl implements LoginServiceInterface {

	@Autowired
	private EmployeDAOInterface employeDAOInterface;

	@Autowired
	private EmployeModel object;

	@Override
	public EmployeModel getEmployeeById(LoginModel user) {
		object = employeDAOInterface.getEmployeeByUserName(user.getUsername());
		if (user.getPassword().equals(object.getPassword())) {
			return object;
		} else {
			return null;
		}
	}
}
