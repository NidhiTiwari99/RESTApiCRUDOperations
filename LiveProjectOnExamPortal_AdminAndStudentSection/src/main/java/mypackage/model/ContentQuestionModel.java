package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tblcontent_questions")
public class ContentQuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="content_id")
	private TopicContentModel topiccontentmodel;
	
	@Column(length = 500)
	private String question;
	@Column(length = 50)
	private String option1;
	@Column(length = 50)
	private String option2;
	@Column(length = 50)
	private String option3;
	@Column(length = 50)
	private String option4;

	
	@OneToMany(mappedBy = "contentquestionmodel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("contentquestionmodel")
	private Set<ExamQuestionModel>examquestionsmodel;

	private int correct_option_number;
	@ColumnDefault("0")
	private int flag;
	
	public ContentQuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContentQuestionModel(int question_id, TopicContentModel topiccontentmodel, String question, String option1,
			String option2, String option3, String option4, Set<ExamQuestionModel> examquestionsmodel,
			int correct_option_number, int flag) {
		super();
		this.question_id = question_id;
		this.topiccontentmodel = topiccontentmodel;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.examquestionsmodel = examquestionsmodel;
		this.correct_option_number = correct_option_number;
		this.flag = flag;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public TopicContentModel getTopiccontentmodel() {
		return topiccontentmodel;
	}
	public void setTopiccontentmodel(TopicContentModel topiccontentmodel) {
		this.topiccontentmodel = topiccontentmodel;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public Set<ExamQuestionModel> getExamquestionsmodel() {
		return examquestionsmodel;
	}
	public void setExamquestionsmodel(Set<ExamQuestionModel> examquestionsmodel) {
		this.examquestionsmodel = examquestionsmodel;
	}
	public int getCorrect_option_number() {
		return correct_option_number;
	}
	public void setCorrect_option_number(int correct_option_number) {
		this.correct_option_number = correct_option_number;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
