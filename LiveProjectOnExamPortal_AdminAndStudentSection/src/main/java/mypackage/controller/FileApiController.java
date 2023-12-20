package mypackage.controller;
import mypackage.model.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import mypackage.services.FileStorageService;
import mypackage.services.StudentDetailsAndQualificationService;
import mypackage.model.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT},allowedHeaders = "*")

public class FileApiController {

	 private static final Logger logger = LoggerFactory.getLogger(FileApiController.class);
	 
	 @Autowired
	 StudentDetailsAndQualificationService studdetailqualservice;
	 
	 @Autowired
	 private FileStorageService fileStorageService;
	 
	 @PostMapping("/uploadFile")
	    public mypackage.model.UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();

	        return new mypackage.model.UploadFileResponse(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }

	  public List<StudentDetailModel>GetStdents(){
		  List<StudentDetailModel>lst=new ArrayList<StudentDetailModel>();
			  for(StudentDetailModel s:studdetailqualservice.GetStudentDetails()) {
				  String fileDownloadUri =
		        			 ServletUriComponentsBuilder.fromCurrentContextPath() 
		        			 .path("/downloadFile/") 
		        			 .path(s.getProfile_photo()) 
		        			 .toUriString(); 
		        	
		        	//Employee emp=new Employee(e.getEmployee_id(), e.getEmployee_name(), fileDownloadUri);
				  StudentDetailModel stud=new StudentDetailModel(s.getStudent_id(), s.getStudent_name(), s.getStudent_code(), s.getPassword(), s.getEmail_address(), s.getMobile_number(), fileDownloadUri, s.getCity(), s.getFlag(), null, null);
		        	lst.add(stud);
		        }
		        return lst;
		  }
	 
	  @GetMapping("api/student")
	  public List<StudentDetailModel>GetStdentDetails(){
		  List<StudentDetailModel>lst=GetStdents();
		        return lst;
		  }

	  @GetMapping("api/student/{id}")
	  public  StudentDetailModel GetStdentDetailById(@PathVariable("id")int id){
		  List<StudentDetailModel>lst=GetStdents();
		 StudentDetailModel sd=null;
		 for(StudentDetailModel s : lst) {
			 if(s.getStudent_id()==id) {
				 sd=s;
				 break;
			 }
		 }
		        return sd;
		  }

	  @PostMapping("api/addstudent")
	  public StudentDetailModel AddStudent(@RequestParam("student_name")String student_name,@RequestParam("student_code")String student_code,@RequestParam("email_address")String email_address,@RequestParam("mobile_number")String mobile_number,@RequestParam("file") MultipartFile file,@RequestParam("city")String city) {
			String fileName = fileStorageService.storeFile(file);
			// Employee e=new Employee(0,employee_name,fileName);
			StudentDetailModel s = new StudentDetailModel(0, student_name, student_code, " ", email_address, mobile_number, fileName, city, 0, null, null);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName).toString();
			UploadFileResponse r = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(),
					file.getSize());
			//logger.info("Uploaded file path"+ fileDownloadUri);
			studdetailqualservice.AddStudentDetails(s);
			return s;
	  }
	  
//	  @PostMapping("/student")
//	  public StudentDetailModel AddStudent(@RequestParam("file") MultipartFile file,@RequestParam("fileNam")String name) {
//	        String fileName = fileStorageService.storeFile(file);
//	        System.out.println(name);
//	        System.out.println(fileName);
//	        //Employee e=new Employee(0,employee_name,fileName);
////	        StudentDetailModel s=new StudentDetailModel(0 ,"", "", "","","",fileName, "",0, null,null);
////	       String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(fileName).toString();
////		  UploadFileResponse r=new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
////		  studdetailqualservice.AddStudentDetails(s);
//		  return new StudentDetailModel();
//	  }
//	  
	  @PostMapping("/uploadMultipleFiles")
	  public List<UploadFileResponse>uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return Arrays.asList(files)
	                .stream()
	                .map(file -> uploadFile(file))
	                .collect(Collectors.toList());
	    }
//	  
	  @GetMapping("/downloadFile/{fileName:.+}")
	  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	            logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }

	 
}
	

