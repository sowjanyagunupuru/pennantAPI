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
import com.example.PennantApI.model.LoginModel;
import com.example.PennantApI.service.Interface.LoginServiceInterface;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceInterface loginServiceInterface;

	@Autowired
	private EmployeModel emp;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@CrossOrigin("http://localhost:4200")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<EmployeModel> finditemById(@RequestBody LoginModel user) {
		try {

			emp = loginServiceInterface.getEmployeeById(user);
			logger.info("In Login controller to get an item.");

			if (emp != null) {
				logger.info("In Login controller to show the requested item.");
				return ResponseEntity.ok(emp);

			} else {
				logger.info("the username or password is invalid.");
				return ResponseEntity.noContent().build();// Return a 404 Not Found response when the item is not found

			}
		} catch (Exception e) {

			e.printStackTrace(); // Handle any other exceptions that might occur
			// Return a 500 Internal Server Error response or another suitable error response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

}
