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
@Table(name="tbltopic_contents")
public class TopicContentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int content_id;
	
	private String content_name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="topic_id")
	private TopicModel topicmodel;
	
	@Column(length = 50)
	private String tblcontent_tutorial;
	@ColumnDefault("0")
	private int flag;
	
	@OneToMany(mappedBy = "topiccontentmodel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("topiccontentmodel")
	private Set<ContentQuestionModel>contentquestionsmodel;
//fetch = FetchType.LAZY =on dimand it will fetch all the record of parent  child //cascade = CascadeType.ALL=delete both parent & child
	public TopicContentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopicContentModel(int content_id, String content_name, TopicModel topicmodel, String tblcontent_tutorial,
			int flag, Set<ContentQuestionModel> contentquestionsmodel) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.topicmodel = topicmodel;
		this.tblcontent_tutorial = tblcontent_tutorial;
		this.flag = flag;
		this.contentquestionsmodel = contentquestionsmodel;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getContent_name() {
		return content_name;
	}

	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}

	public TopicModel getTopicmodel() {
		return topicmodel;
	}

	public void setTopicmodel(TopicModel topicmodel) {
		this.topicmodel = topicmodel;
	}

	public String getTblcontent_tutorial() {
		return tblcontent_tutorial;
	}

	public void setTblcontent_tutorial(String tblcontent_tutorial) {
		this.tblcontent_tutorial = tblcontent_tutorial;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Set<ContentQuestionModel> getContentquestionsmodel() {
		return contentquestionsmodel;
	}

	public void setContentquestionsmodel(Set<ContentQuestionModel> contentquestionsmodel) {
		this.contentquestionsmodel = contentquestionsmodel;
	}
	
	
	

}
