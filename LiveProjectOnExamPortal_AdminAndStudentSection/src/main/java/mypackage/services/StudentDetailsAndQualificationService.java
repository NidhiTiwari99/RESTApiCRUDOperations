package mypackage.services;


import mypackage.model.*;
import mypackage.repository.ContentQuestionRepository;
import mypackage.repository.ExamDetailRepository;
import mypackage.repository.ExamQuestionRepository;
import mypackage.repository.StudentDetailRepository;
import mypackage.repository.StudentQualificationRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsAndQualificationService {

	@Autowired
	StudentDetailRepository studdetailrepo;

	@Autowired
	StudentQualificationRepository studqualrepo;

	@Autowired
	ExamDetailRepository examdetailrepo;

	@Autowired
	ExamQuestionRepository examquestionrepo;

	@Autowired
	Emailservice emailservice;
	
	@Autowired
	ContentQuestionRepository questionrepo;
	
	public List<StudentDetailModel> GetStudentDetails() {
		List<StudentDetailModel> lst = new ArrayList<StudentDetailModel>();
		for (StudentDetailModel sd : studdetailrepo.findAll()) {
			// StudentDetailModel m=new StudentDetailModel(student_id, student_name,
			// student_code, email_address, mobile_number, profile_photo, city, flag,
			// examdetailsmodel)
			StudentDetailModel dm = new StudentDetailModel(sd.getStudent_id(), sd.getStudent_name(), sd.getStudent_code(),sd.getPassword(), sd.getEmail_address(), sd.getMobile_number(), sd.getProfile_photo(), sd.getCity(), sd.getFlag(), null, null);
			lst.add(dm);
		}
		return lst;
	}
	
	public StudentDetailModel GetStudentbyID(int student_id){
		StudentDetailModel s=studdetailrepo.findById(student_id).get();
		return s;
	}
	
	public String GeneratePassword(int size) {
		String data="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$";
		String password="";
		Random r=new Random();
		for(int i=1; i<=size; i++) {
			password+=data.charAt(r.nextInt(data.length()-1));
			
		}
		return password;
	}
	
	public String GenerateNextStudentCode() {
		String student_code="";
		
		List<StudentDetailModel>lst=studdetailrepo.findAll();
		int id=0;
		if(lst.size()>0) {
			id=lst.size()+1;
		}
		else {
			id=1;
		}
		student_code="S";
		if(id<10) {
		student_code=student_code+"00000000"+id;
		}
		else if(id>=10 && id<99) {
			student_code=student_code+"0000000"+id;
		}
		else if(id>=100 && id<999) {
			student_code=student_code+"000000"+id;
		}
		else if(id>=1000 && id<9999) {
			student_code=student_code+"000000"+id;
		}
		return student_code;
	}

	
	public StudentDetailModel AddStudentDetails(StudentDetailModel d) {
		//StudentDetailModel st=new StudentDetailModel(d.getStudent_id(), d.getStudent_name(), GenerateNextStudentCode(), GeneratePassword(6), d.getEmail_address(), d.getMobile_number(), d.getProfile_photo(), d.getCity(), d.getFlag(), null, null);
		String password=GeneratePassword(10);
		//EmailModel em=new EmailModel(d.getEmail_address(), "Employee Registration Confirmation", "Dear" +d.getStudent_name()+ "Your Account Has Been Created Successfully. You Can Login with your Student Code="+d.getStudent_code()+" and Below mentioned random password="+d.getPassword());
		StudentDetailModel st=new StudentDetailModel(d.getStudent_id(), d.getStudent_name(), GenerateNextStudentCode(), password,d.getEmail_address(), d.getMobile_number(), d.getProfile_photo(), d.getCity(), d.getFlag(), null, null);
		StudentDetailModel dm = studdetailrepo.save(st);
		SendEmail(st);
		return dm;
		}
	
	public EmailModel SendEmail(StudentDetailModel s) {
		//String student_code=GenerateNextStudentCode();
		//Employee emp=emprepo.save(e);
		EmailModel em=new EmailModel(s.getEmail_address(), "Employee Registration Confirmation", "Dear" +" "+s.getStudent_name()+ " "+"Your Account Has Been Created Successfully. You Can Login with your Student Code="+s.getStudent_code()+" and Below mentioned random password="+s.getPassword());
	emailservice.SendEmail(em);
	return em;
	}
	
	
	

	public List<StudentQualificationModel> GetStudentQualifications() {
		List<StudentQualificationModel> lst = new ArrayList<StudentQualificationModel>();
		for (StudentQualificationModel sq : studqualrepo.findAll()) {
			// StudentQualificationModel q=new StudentQualificationModel(qualification_id,
			// qualification, university, passing_year, percentage, flag)
			StudentDetailModel sd =new StudentDetailModel(sq.getStudentdetail().getStudent_id(), sq.getStudentdetail().getStudent_name(), sq.getStudentdetail().getStudent_code(),sq.getStudentdetail().getPassword(), sq.getStudentdetail().getEmail_address(), sq.getStudentdetail().getMobile_number(), sq.getStudentdetail().getProfile_photo(), sq.getStudentdetail().getCity(), sq.getStudentdetail().getFlag(), null, null);
			StudentQualificationModel qm=new StudentQualificationModel(sq.getQualification_id(),sq.getQualification(), sq.getUniversity(), sq.getPassing_year(), sq.getPercentage(), sq.getFlag(), sd);
			lst.add(qm);
		}
		return lst;
	}

	public StudentQualificationModel AddStudentQualifications(StudentQualificationModel q) {
		StudentQualificationModel qm = studqualrepo.save(q);
		return qm;
	}

	public List<ExamDetailModel> GetExamDetails() {
		List<ExamDetailModel> lst = new ArrayList<ExamDetailModel>();
		for (ExamDetailModel ed : examdetailrepo.findAll()) {
			StudentDetailModel sd = new StudentDetailModel(ed.getStudentdetailmodel().getStudent_id(),
					ed.getStudentdetailmodel().getStudent_name(), ed.getStudentdetailmodel().getStudent_code(),ed.getStudentdetailmodel().getPassword(),
					ed.getStudentdetailmodel().getEmail_address(), ed.getStudentdetailmodel().getMobile_number(),
					ed.getStudentdetailmodel().getProfile_photo(), ed.getStudentdetailmodel().getCity(),
					ed.getStudentdetailmodel().getFlag(), null,null);
//			ExamDetailModel dm=new ExamDetailModel(exam_id, studentdetailmodel, exam_date, start_time, end_time, flag, examquestionsmodel)
			ExamDetailModel dm = new ExamDetailModel(ed.getExam_id(), sd, ed.getExam_date(), ed.getStart_time(),ed.getEnd_time(), ed.getFlag(), null);
			lst.add(dm);
		}
		return lst;
	}

//	public ExamDetailModel AddExamDetails(ExamDetailModel d) {
//		ExamDetailModel dm = examdetailrepo.save(d);
//		return dm;
//	}

	

	public ExamDetailModel AddExamDetails(ExamDetailModel e)
	{
		
		ExamDetailModel em=new ExamDetailModel(0, e.getStudentdetailmodel(), e.getExam_date(), e.getStart_time(), e.getEnd_time(), e.getFlag(), null);
		ExamDetailModel ed=examdetailrepo.save(em);
		for(ExamQuestionModel eq:e.getExamquestionsmodel())
		{
			ExamQuestionModel exq=new ExamQuestionModel(0, ed, eq.getContentquestionmodel(), eq.getSubmitted_option_number());
			//ExamQuestionModel ed=new ExamQuestionModel(exam_question_id, examdetailmodel, contentquestionmodel, submitted_option_number)
			examquestionrepo.save(exq);
		}
		return e;
	}
	

	
	
	 public List<ExamQuestionModel> GetExamQuestions(){
	  List<ExamQuestionModel>lst=new ArrayList<ExamQuestionModel>();
	for(ExamQuestionModel eq:examquestionrepo.findAll()) { 
		//String content_name=eq.getContentquestionmodel().ge
		ContentQuestionModel cq=new ContentQuestionModel(eq.getContentquestionmodel().getQuestion_id(), null, eq.getContentquestionmodel().getQuestion(),eq.getContentquestionmodel().getOption1(),eq.getContentquestionmodel().getOption2(), eq.getContentquestionmodel().getOption3(), eq.getContentquestionmodel().getOption4(), null,eq.getContentquestionmodel().getCorrect_option_number(), eq.getContentquestionmodel().getFlag());
	ExamDetailModel dm=new ExamDetailModel(eq.getExamdetailmodel().getExam_id(), null,
	 eq.getExamdetailmodel().getExam_date(),
	 eq.getExamdetailmodel().getStart_time(),
	 eq.getExamdetailmodel().getEnd_time(), eq.getExamdetailmodel().getFlag(),
	 null);
	  //ExamQuestionModel qm =new ExamQuestionModel(exam_question_id,examdetailmodel, contentquestionmodel, submitted_option_number)
	ExamQuestionModel qm=new ExamQuestionModel(eq.getExam_question_id(), dm, cq,eq.getSubmitted_option_number()); lst.add(qm); } 
	return lst; 
	 }
	 
	 public List<QuestionModel> GetQuestions(){
		 List<QuestionModel>lst=new ArrayList<QuestionModel>();
		for(ContentQuestionModel q:questionrepo.findAll()) {
		String	content_name=q.getTopiccontentmodel().getContent_name();
			int  content_id=q.getTopiccontentmodel().getContent_id();
			String topic_name=q.getTopiccontentmodel().getTopicmodel().getTopic_name();
			int topic_id=q.getTopiccontentmodel().getTopicmodel().getTopic_id();
			QuestionModel qm=new QuestionModel(q.getQuestion_id(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getCorrect_option_number(), content_id, content_name, topic_id, topic_name);
			lst.add(qm);	
		}
		return lst;
	 }
	
	 public List<QuestionModel>GetTopiWiseQuestion(int topic_id){
		 List<QuestionModel>lst=new ArrayList<QuestionModel>();
		 for(QuestionModel q:GetQuestions()) {
			 if(q.getTopic_id()==topic_id) {
				 lst.add(q);
			 }
		 }
		 return lst;
	 }

	public ExamQuestionModel AddExamQuestions(ExamQuestionModel q) {
		ExamQuestionModel qm = examquestionrepo.save(q);
		return qm;
	}
	
	public StudentDetailModel GetStudentById(int id)
	{
		StudentDetailModel d=studdetailrepo.findById(id).get();
		StudentDetailModel details=new StudentDetailModel(d.getStudent_id(), d.getStudent_name(), d.getPassword(), d.getStudent_code(), d.getEmail_address(), d.getMobile_number(), d.getProfile_photo(), d.getCity(), d.getFlag(), null, null);
		return details;
	}
	
	public List<ExamDetailModel>GetExamDetailByStudentId(int stud_id){// Get Exam Detail By Student Id Function.
		List<ExamDetailModel>lst=new ArrayList<ExamDetailModel>();
		for(ExamDetailModel e:examdetailrepo.findAll()) {
			if(e.getStudentdetailmodel().getStudent_id()==stud_id) {
				//StudentDetails sd=new StudentDetails(e.getStudent_id(), e.getStudentDetail().getStudent_name(), "","", "","", "", "", 0, null, null);
				StudentDetailModel sd=new StudentDetailModel(e.getStudentdetailmodel().getStudent_id(), e.getStudentdetailmodel().getStudent_name(), "", "", "", "", "", "", 0, null, null);
				ExamDetailModel ed=new ExamDetailModel(e.getExam_id(), sd, e.getExam_date(), e.getStart_time(), e.getEnd_time(), 0, null);
				lst.add(ed);
			}
		}
		return lst;
	}
	

	
	
	public StudentDetailModel checkStudentLogin(String code,String password)
	{
		StudentDetailModel std=null;
		List<StudentDetailModel>lst=GetStudentDetails();
		for(StudentDetailModel s :lst) {
			if(s.getStudent_code().equals(code) && s.getPassword().equals(password)) {
				

				std=new StudentDetailModel(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(),"", s.getEmail_address(), s.getMobile_number(), s.getProfile_photo(), s.getCity(), 0, null, null);
			
				break;
			}
	}
		
			return std;		
	}

}
