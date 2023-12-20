package mypackage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mypackage.service.*;

import mypackage.model.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class StudentQualificationApiController {

	@Autowired
	StudentQualificationServices studqualservice;
	
	@PostMapping("api/studentqualification")
	public Student AddStudentqualificationData(@RequestBody Student st) {
		System.out.println(st.getStudent_name());
		for(Qualification q:st.getQualifications()) {
			System.out.println(q.getQualification_name());
		}
	Student s=studqualservice.AddStudent(st);
		return s;
}
	@GetMapping("api/studentqualification")
	public List<Student>GetStudents(){
		return studqualservice.GetStudents();
	}
	
	public List<Qualification>GetQualifications(){
		return studqualservice.GetQualifications();
	}
	
}