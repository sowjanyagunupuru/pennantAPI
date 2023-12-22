package com.example.PennantApI.service.Interface;

import org.springframework.stereotype.Service;

import com.example.PennantApI.model.EmployeModel;
import com.example.PennantApI.model.LoginModel;

@Service
public interface LoginServiceInterface {

	public EmployeModel getEmployeeById(LoginModel user);

}
