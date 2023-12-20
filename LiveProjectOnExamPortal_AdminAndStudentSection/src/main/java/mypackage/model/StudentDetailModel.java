package mypackage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tblstudent_details")
public class StudentDetailModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int student_id;
private String student_name;
@Column(unique = true , length = 50)
@NonNull
private String student_code;
private String password;
public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




@Column(unique=true)
@NonNull
private String email_address;
@Column(length = 20)
private String mobile_number;
@Column(length = 100)
private String profile_photo;
private String city;
@ColumnDefault("0")
private int flag;


public StudentDetailModel(int student_id, String student_name, String student_code, String password,
		String email_address, String mobile_number, String profile_photo, String city, int flag,
		Set<StudentQualificationModel> studentqualifications, Set<ExamDetailModel> examdetailsmodel) {
	super();
	this.student_id = student_id;
	this.student_name = student_name;
	this.student_code = student_code;
	this.password = password;
	this.email_address = email_address;
	this.mobile_number = mobile_number;
	this.profile_photo = profile_photo;
	this.city = city;
	this.flag = flag;
	this.studentqualifications = studentqualifications;
	this.examdetailsmodel = examdetailsmodel;
}




@OneToMany(mappedBy = "studentdetail",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JsonIgnoreProperties("studentdetail")
private Set<StudentQualificationModel>studentqualifications;


@OneToMany(mappedBy = "studentdetailmodel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JsonIgnoreProperties("studentdetailmodel")
private Set<ExamDetailModel>examdetailsmodel;



public int getStudent_id() {
	return student_id;
}




public void setStudent_id(int student_id) {
	this.student_id = student_id;
}




public String getStudent_name() {
	return student_name;
}




public void setStudent_name(String student_name) {
	this.student_name = student_name;
}




public String getStudent_code() {
	return student_code;
}




public void setStudent_code(String student_code) {
	this.student_code = student_code;
}




public String getEmail_address() {
	return email_address;
}




public void setEmail_address(String email_address) {
	this.email_address = email_address;
}




public String getMobile_number() {
	return mobile_number;
}




public void setMobile_number(String mobile_number) {
	this.mobile_number = mobile_number;
}




public String getProfile_photo() {
	return profile_photo;
}




public void setProfile_photo(String profile_photo) {
	this.profile_photo = profile_photo;
}




public String getCity() {
	return city;
}




public void setCity(String city) {
	this.city = city;
}




public int getFlag() {
	return flag;
}




public void setFlag(int flag) {
	this.flag = flag;
}




public Set<StudentQualificationModel> getStudentqualifications() {
	return studentqualifications;
}




public void setStudentqualifications(Set<StudentQualificationModel> studentqualifications) {
	this.studentqualifications = studentqualifications;
}




public Set<ExamDetailModel> getExamdetailsmodel() {
	return examdetailsmodel;
}




public void setExamdetailsmodel(Set<ExamDetailModel> examdetailsmodel) {
	this.examdetailsmodel = examdetailsmodel;
}




public StudentDetailModel() {
	super();
	// TODO Auto-generated constructor stub
}


}
