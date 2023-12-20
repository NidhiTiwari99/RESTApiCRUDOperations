package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbltopics")
public class TopicModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topic_id;
	@Column(unique=true)
	@NonNull
	private String topic_name;
	@ColumnDefault("0")
    private int flag;
	
	@OneToMany(mappedBy = "topicmodel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("topicmodel")
	private Set<TopicContentModel>topiccontentmodel;

	public TopicModel(int topic_id, String topic_name, int flag, Set<TopicContentModel> topiccontentmodel) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.flag = flag;
		this.topiccontentmodel = topiccontentmodel;
	}

	public TopicModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Set<TopicContentModel> getTopiccontentmodel() {
		return topiccontentmodel;
	}

	public void setTopiccontentmodel(Set<TopicContentModel> topiccontentmodel) {
		this.topiccontentmodel = topiccontentmodel;
	}
}

	