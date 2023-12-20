package mypackage.controller;

import mypackage.services.*;
import mypackage.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")

public class StudentApiController {

	@Autowired
	StudentDetailsAndQualificationService studdetailqualservice;
	
//	@GetMapping("api/student")
//	public List<StudentDetailModel> GetStdentDetails(){
//		return studdetailqualservice.GetStudentDetails();
//	}
//	
	@GetMapping("api/newstudent")
	public StudentDetailModel NewStudentDetails() {
		String student_code=studdetailqualservice.GenerateNextStudentCode();
		StudentDetailModel sd=new StudentDetailModel(0, "", student_code, "", "", "", "", "", 0, null, null);
		return sd;
	}
	
	  // @Autowired
	 //   private FileStorageService fileStorageService;

	
	
	@GetMapping("api/studentqualification")
	public List<StudentQualificationModel> GetQualifications(){
		return studdetailqualservice.GetStudentQualifications();
	}
	
	@GetMapping("api/examdetail")
	public List<ExamDetailModel> GetExamDetails(){
		return studdetailqualservice.GetExamDetails();
	}
	
	
	@GetMapping("api/examquestion") 
	public List<QuestionModel>GetExamQuestions(){ 
		return studdetailqualservice.GetQuestions();
	}
	
	@GetMapping("api/topicwisequestions/{id}") 
	public List<QuestionModel>GetExamQuestion(@PathVariable("id") int id){ 
		return studdetailqualservice.GetTopiWiseQuestion(id);
	}
	
	
	
//	@PostMapping("api/student")
//	public StudentDetailModel AddStdentDetail(@RequestBody StudentDetailModel d){
//		return studdetailqualservice.AddStudentDetails(d);
//	}
	
//	@PostMapping("/api/student")
//    public StudentDetailModel AddStudent(@RequestParam("file") MultipartFile file,@RequestParam("student_name")String student_name,@RequestParam("student_code")String student_code,@RequestParam("email_address")String email_address,@RequestParam("mobile_number")String mobile_number,@RequestParam("city")String city) {
//        String fileName = fileStorageService.storeFile(file);
//        StudentDetailModel e=new StudentDetailModel(0, student_name, student_code, "", email_address, mobile_number, fileName, city, 0, null, null);
//        
////        e.setPhoto_name(fileName);
////        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
////                .path("/downloadFile/")
////                .path(fileName)
////                .toUriString();
////       UploadFileResponse r= new UploadFileResponse(fileName, fileDownloadUri,
////                file.getContentType(), file.getSize());
//           studdetailqualservice.AddStudentDetails(e);
//        return e;
//    }
	
//	 @GetMapping("api/student")
//	    public List<StudentDetailModel>GetAllStudents(){
//	    	List<StudentDetailModel>lst=new ArrayList<StudentDetailModel>();
//	    	for(StudentDetailModel e : studdetailqualservice.GetStudentDetails()) {
//	    		 String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	    	                .path("/downloadFile/")
//	    	                .path(e.getProfile_photo())
//	    	                .toUriString();
//	    		 StudentDetailModel sd=new StudentDetailModel(e.getStudent_id(), e.getStudent_name(),e.getStudent_code(), "", e.getEmail_address(), e.getMobile_number(), fileDownloadUri, e.getCity(), e.getFlag(), null, null);
//	    		 	lst.add(sd);
//	    	}
//	    	return lst;
//	    }
//@GetMapping("api/student/{id}")
//public StudentDetailModel GetStudentById(@PathVariable("id") int id) {
//	return studdetailqualservice.GetStudentbyID(id);
//}
	
	@PostMapping("api/studentqualification")
	public StudentQualificationModel AddQualification(@RequestBody StudentQualificationModel q){
		return studdetailqualservice.AddStudentQualifications(q);
	}
	
	@PostMapping("api/examdetail")
	public ExamDetailModel AddExamDetail(@RequestBody ExamDetailModel d){
		return studdetailqualservice.AddExamDetails(d);
	}
	
	@PostMapping("api/examquestion")
	public ExamQuestionModel AddExamQuestion(@RequestBody ExamQuestionModel q){
		return studdetailqualservice.AddExamQuestions(q);
	}
	
	@PostMapping("api/studentlogin")
	public StudentDetailModel CheckStudentLogin(@RequestParam("student_code")String code , @RequestParam("password")String pass)
	{

		StudentDetailModel st=studdetailqualservice.checkStudentLogin(code, pass);
		return st;
		//return eservice.checkstudent(e.getStudent(), e.getUsername(), e.getPassword());
	}
	
//	@GetMapping("api/qualification/{id}")
//	public StudentQualificationModel GetStudentQualificationById(@PathVariable("id")int id) {
//		return studdetailqualservice.GetStudent(id);
//	}
//	@PutMapping("api/qualification")
//	public StudentQualificationModel UpdateStudentQualification(StudentQualificationModel sq) {
//		return studdetailqualservice.updateQualification(sq);
//	}
//	@DeleteMapping("api/qualification")
//	public StudentQualificationModel DeletestudentQualification(@PathVariable("id")int id) {
//		return studdetailqualservice.DeleteQualification(id);
//		
//		
//	}

	@GetMapping("api/examDetailByStudentId/{id}")
	public List<ExamDetailModel>GetExamDetailByStudentId(@PathVariable("id")int id){
		return studdetailqualservice.GetExamDetailByStudentId(id);
	}
	
	//@GetMapping("api/exam")
//	public List<ExamDetailMo>GetExamDetails()
//	{
//		return eservice.GetExamDeatsila();
//	}
//
//	@PostMapping("api/exam")
//	public ExamDetails AddExamDetails(@RequestBody ExamDetails cq)
//	{
//		for(ExamQuestion q:cq.getExamquestion())
//		{
//		System.out.println(q.getContentquestion().getQuestion_id());
//		}
//		return eservice.AddExamDetails(cq);
//	}
//	
//	
//	@GetMapping("api/examquestion")
//	public List<QuestionModel>GetExamQuestion()
//	{
//		return eservice.GetQuestions();
//	}
//	
//	@GetMapping("api/topicwisequestions/{id}")
//	public List<QuestionModel>GetExamQuestion(@PathVariable("id") int id)
//	{
//		return eservice.GetTopicWiseQuestions(id);
//	}
//	
//	@PostMapping("api/examquestion")
//	public ExamQuestion AddExamQuestion(@RequestBody ExamQuestion cq)
//	{
//		return eservice.AddexamQuestion(cq);
//	}
//	
//	
//	
//	@GetMapping("api/examquestion")
//	public List<ExamQuestion>GetExamQuestions()
//	{
//		return eservice.GetExamQuestion();
//	}
	
	
	
//	@GetMapping("api/studentqualification")
//	public List<student_qualification>Getstudentqualification()
//	{
//		return eservice.StudentQualification();
//	}
//	
//	@PostMapping("api/studentqualification")
//	public student_qualification  Addstudentqualification(@RequestBody student_qualification cq)
//	{
//		return eservice.Addstudent_qualification(cq);
//	}
//	
	

}
