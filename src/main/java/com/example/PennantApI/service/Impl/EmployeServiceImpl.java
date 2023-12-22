package com.example.PennantApI.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PennantApI.DAO.Interface.EmployeDAOInterface;
import com.example.PennantApI.model.EmployeModel;
import com.example.PennantApI.service.Interface.EmployeServiceInterface;

@Service
public class EmployeServiceImpl implements EmployeServiceInterface {
	@Autowired
	private EmployeDAOInterface employeDAOInterface;

	@Autowired
	private EmployeModel object;

	@Override
	public EmployeModel getEmployeeById(EmployeModel user) {
		object = employeDAOInterface.getEmployeeById(user.getEmpId());
		return object;
	}
}
