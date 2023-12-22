package com.example.PennantApI.service.Interface;

import org.springframework.stereotype.Service;

import com.example.PennantApI.model.EmployeModel;

@Service
public interface EmployeServiceInterface {
	public EmployeModel getEmployeeById(EmployeModel user);
}
