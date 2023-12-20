package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="tblstudent_qualifications")
public class StudentQualificationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qualification_id;
	private String qualification;
	private String university;
	private int passing_year;
	private float percentage;
	@ColumnDefault("0")
	private int flag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id")
	private StudentDetailModel studentdetail;
	
	
	public StudentQualificationModel(int qualification_id, String qualification, String university, int passing_year,
			float percentage, int flag, StudentDetailModel studentdetail) {
		super();
		this.qualification_id = qualification_id;
		this.qualification = qualification;
		this.university = university;
		this.passing_year = passing_year;
		this.percentage = percentage;
		this.flag = flag;
		this.studentdetail = studentdetail;
	}

	public StudentDetailModel getStudentdetail() {
		return studentdetail;
	}

	public void setStudentdetail(StudentDetailModel studentdetail) {
		this.studentdetail = studentdetail;
	}

	public StudentQualificationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(int qualification_id) {
		this.qualification_id = qualification_id;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public int getPassing_year() {
		return passing_year;
	}
	public void setPassing_year(int passing_year) {
		this.passing_year = passing_year;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
