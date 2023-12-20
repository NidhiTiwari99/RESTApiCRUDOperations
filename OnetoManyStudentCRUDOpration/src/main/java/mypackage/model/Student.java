package mypackage.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tblstudent")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	private String email_address;
	private String mobile_number;
	private String city;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private Set<Qualification> qualifications;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String student_name, String email_address, String mobile_number, String city,
			Set<Qualification> qualifications) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.email_address = email_address;
		this.mobile_number = mobile_number;
		this.city = city;
		this.qualifications = qualifications;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

}
