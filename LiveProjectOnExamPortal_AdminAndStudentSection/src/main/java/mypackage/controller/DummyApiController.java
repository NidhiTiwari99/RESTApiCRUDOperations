package mypackage.controller;
import mypackage.model.*;
import mypackage.services.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyApiController {

	@Autowired
	DummyService serv;
	
	@GetMapping("api/dummytopic/{id}")
	public List<TopicModel>GetAll(@PathVariable("id")int id){
		return serv.GetTopics(id);
	}
}
