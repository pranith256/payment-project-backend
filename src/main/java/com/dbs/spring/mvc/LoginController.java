package com.dbs.spring.mvc;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Customeruser;
import com.dbs.spring.model.UserData;
import com.dbs.spring.service.CustomeruserService;

@CrossOrigin
@RestController
@RequestMapping
public class LoginController {

	@Autowired
	private CustomeruserService service;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserData user)
	{
		try {
	
		Customeruser cu= this.service.getAllBycustomerId(user.getUn());
		if(cu.getUserid()==user.getUn() && cu.getUserpassword().equals(user.getPass())) {
			return ResponseEntity.status(HttpStatus.OK)
                    .body(cu);
		}
		

		else { return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("not found");
		
	
		}
		}
		catch(EntityNotFoundException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("error logging in ");
		}
	}
		
	
}
