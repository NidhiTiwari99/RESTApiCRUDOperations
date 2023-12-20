package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentqualification")
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qualification_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="student_id")
	
	private Student student;
	private String qualification_name;
	private String university;
	private String passing_year;
	private float percentage;
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualification(int qualification_id, Student student, String qualification_name, String university,
			String passing_year, float percentage) {
		super();
		this.qualification_id = qualification_id;
		this.student = student;
		this.qualification_name = qualification_name;
		this.university = university;
		this.passing_year = passing_year;
		this.percentage = percentage;
	}
	public int getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(int qualification_id) {
		this.qualification_id = qualification_id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getQualification_name() {
		return qualification_name;
	}
	public void setQualification_name(String qualification_name) {
		this.qualification_name = qualification_name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getPassing_year() {
		return passing_year;
	}
	public void setPassing_year(String passing_year) {
		this.passing_year = passing_year;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
}
