package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.*;
import mypackage.services.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class EmailApiController {


	@Autowired
	Emailservice emailservice;
	
	@PostMapping("api/sendemail")
	public EmailModel SendEmail(@RequestBody EmailModel em) {
		String str=emailservice.SendEmail(em);
		System.out.println(str);
		return em;
	}
}
