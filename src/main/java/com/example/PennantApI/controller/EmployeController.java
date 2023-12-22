package com.example.PennantApI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.PennantApI.model.EmployeModel;
import com.example.PennantApI.service.Interface.EmployeServiceInterface;

@RestController
public class EmployeController {

	@Autowired
	private EmployeServiceInterface employeServiceInterface;

	@Autowired
	private EmployeModel emp;

	private static final Logger logger = LoggerFactory.getLogger(EmployeController.class);

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/getEmployeById", method = RequestMethod.POST)
	public ResponseEntity<EmployeModel> finditemById(@RequestBody EmployeModel user) {
		try {

			emp = employeServiceInterface.getEmployeeById(user);
			logger.info("In Emplopyee controller to get an object.");

			if (emp != null) {
				logger.info("In Employee controller to show the requested object.");
				return ResponseEntity.ok(emp);

			} else {
				logger.info("Employe doesn't exists with this name.");
				return ResponseEntity.noContent().build();// Return a 404 Not Found response when the item is not found

			}
		} catch (Exception e) {

			e.printStackTrace(); // Handle any other exceptions that might occur
			// Return a 500 Internal Server Error response or another suitable error response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
}
