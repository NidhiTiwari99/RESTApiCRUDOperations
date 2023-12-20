package mypackage.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import mypackage.model.*;
import mypackage.repository.QualificationRepository;
import mypackage.repository.StudentRepository;

@Service
public class StudentQualificationServices {

	@Autowired
	StudentRepository studrepo;
	@Autowired
	QualificationRepository qualrepo;
	
	public Student AddStudent(Student st) {
		Student s=new Student(0, st.getStudent_name(), st.getEmail_address(), st.getMobile_number(), st.getCity(), null);
		Student stud =studrepo.save(s);
		for(Qualification q:st.getQualifications()) {
			Qualification qn=new Qualification(0, stud, q.getQualification_name(), q.getUniversity(), q.getPassing_year(), q.getPercentage());
			qualrepo.save(qn);
		}
		return stud;
	}
	public List<Student>GetStudents(){
		return studrepo.findAll();
	}
	
	public List<Qualification>GetQualifications(){
		return qualrepo.findAll();
	}
}
