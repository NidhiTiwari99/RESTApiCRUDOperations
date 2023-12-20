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
@Table(name="tblexam_questions")
public class ExamQuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_question_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="exam_id")
	private  ExamDetailModel examdetailmodel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	private ContentQuestionModel contentquestionmodel;
	private int submitted_option_number;
	
	public ExamQuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamQuestionModel(int exam_question_id, ExamDetailModel examdetailmodel,
			ContentQuestionModel contentquestionmodel, int submitted_option_number) {
		super();
		this.exam_question_id = exam_question_id;
		this.examdetailmodel = examdetailmodel;
		this.contentquestionmodel = contentquestionmodel;
		this.submitted_option_number = submitted_option_number;
	}
	public int getExam_question_id() {
		return exam_question_id;
	}
	public void setExam_question_id(int exam_question_id) {
		this.exam_question_id = exam_question_id;
	}
	public ExamDetailModel getExamdetailmodel() {
		return examdetailmodel;
	}
	public void setExamdetailmodel(ExamDetailModel examdetailmodel) {
		this.examdetailmodel = examdetailmodel;
	}
	public ContentQuestionModel getContentquestionmodel() {
		return contentquestionmodel;
	}
	public void setContentquestionmodel(ContentQuestionModel contentquestionmodel) {
		this.contentquestionmodel = contentquestionmodel;
	}
	public int getSubmitted_option_number() {
		return submitted_option_number;
	}
	public void setSubmitted_option_number(int submitted_option_number) {
		this.submitted_option_number = submitted_option_number;
	}
}
