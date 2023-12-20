package mypackage.services;

import mypackage.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mypackage.repository.*;

@Service
public class TopicTopicContentAndQuestionService {

	@Autowired
	TopicRepository topicrepo;
	
	@Autowired
	TopicContentRepository topiccontentrepo;
	
	@Autowired
	ContentQuestionRepository contentquestionrepo;
	

	
	public List<TopicModel>GetTopics(){
		List<TopicModel>lst=new ArrayList<TopicModel>();
		for(TopicModel t: topicrepo.findAll()) {
			if(t.getFlag()==0)
			{
			TopicModel tm=new TopicModel(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null);
			lst.add(tm);
			}
			}
		return lst;
	}
	
	public TopicModel GetTopic(int id) {
		TopicModel t=topicrepo.findById(id).get();
		TopicModel tp=new TopicModel(t.getTopic_id(), t.getTopic_name(), t.getFlag(), null);
		return tp;
	}
	
	public TopicModel DeleteTopic(int id) {
		TopicModel st =GetTopic(id);
		st.setFlag(1);
        TopicModel s=topicrepo.save(st);
		return s;
	}
	
	public TopicModel RestoreTopic(int id) {
		TopicModel st =GetTopic(id);
		st.setFlag(0);
		TopicModel s=topicrepo.save(st);
		return s;
	}
	
	public TopicModel UpdateTopic(TopicModel tm) {
		System.out.println(tm.getTopic_id()+" "+tm.getTopic_name());
		TopicModel s=topicrepo.save(tm);
		return s;
	}
	
	public List<TopicContentModel>GetTopicContents(){
		List<TopicContentModel>lst=new ArrayList<TopicContentModel>();
		for(TopicContentModel tc:topiccontentrepo.findAll()) {
			if(tc.getFlag()==0) {
			TopicModel tm= new TopicModel(tc.getTopicmodel().getTopic_id(), tc.getTopicmodel().getTopic_name(), tc.getTopicmodel().getFlag(), null);
			//TopicContentModel cm =new TopicContentModel(content_id, content_name, topicmodel, tblcontent_tutorial, flag, contentquestionsmodel)
			TopicContentModel cm=new TopicContentModel(tc.getContent_id(), tc.getContent_name(), tm, tc.getTblcontent_tutorial(), tc.getFlag(),null);
			//System.out.println(cm);
			lst.add(cm);
			}
		}
			return lst;
		}
		
	public List <TopicContentModel> GetTopicContent(int id) {
	List<TopicContentModel> lst=new ArrayList<TopicContentModel>();
		for(TopicContentModel c:topiccontentrepo.findAll()) {
			if(c.getTopicmodel().getTopic_id()==id) {
		TopicModel tm= new TopicModel(c.getTopicmodel().getTopic_id(), c.getTopicmodel().getTopic_name(), c.getTopicmodel().getFlag(), null);
		TopicContentModel cm=new TopicContentModel(c.getContent_id(), c.getContent_name(), tm, c.getTblcontent_tutorial(), c.getFlag(), null);
		lst.add(cm);
		}
		}
	return lst;
	}
	
//		public TopicContentModel GetTopicContent(int id) {
//			TopicContentModel c = topiccontentrepo.findById(id).get();
//			TopicModel tm = new TopicModel(c.getTopicmodel().getTopic_id(), c.getTopicmodel().getTopic_name(),
//					c.getTopicmodel().getFlag(), null);
//			TopicContentModel cm = new TopicContentModel(c.getContent_id(), c.getContent_name(), tm,
//					c.getTblcontent_tutorial(), c.getFlag(), null);
//			return cm;
//		}
	
	public TopicContentModel DeleteTopicContent(int id) {
		TopicContentModel c=topiccontentrepo.findById(id).get();
		c.setFlag(1);
//		st.setTopicmodel(st.getTopicmodel());
		TopicContentModel s=topiccontentrepo.save(c);
		s.setTopicmodel(null);
		return s;
	}
	
//	public TopicContentModel RestoreTopicContent(int id) {
//		TopicContentModel st =GetTopicContent(id);
//		st.setFlag(0);
//		TopicContentModel s=topiccontentrepo.save(st);
//		return s;
//	}
	
	public TopicContentModel UpdateTopicContent(TopicContentModel tm) {
		System.out.println(tm.getContent_id()+" "+tm.getContent_name());
		TopicContentModel s=topiccontentrepo.save(tm);
		return s;
	}
	public List<ContentQuestionModel>GetContentQuestions(){
		List<ContentQuestionModel>lst=new ArrayList<ContentQuestionModel>();
		for(ContentQuestionModel cq:contentquestionrepo.findAll()) {
			TopicContentModel tc=new TopicContentModel(cq.getTopiccontentmodel().getContent_id(), cq.getTopiccontentmodel().getContent_name(), null, cq.getTopiccontentmodel().getTblcontent_tutorial(), cq.getTopiccontentmodel().getFlag(), null);
			ContentQuestionModel qm=new ContentQuestionModel(cq.getQuestion_id(), tc, cq.getQuestion(), cq.getOption1(), cq.getOption2(),cq.getOption3(), cq.getOption4(), cq.getExamquestionsmodel(), cq.getCorrect_option_number(), cq.getFlag());
		lst.add(qm);
		}
		
		return lst;
	}
	
	
	public TopicModel AddTopic(TopicModel t) {
		TopicModel tp=topicrepo.save(t);
		return tp;
	}
	
	public TopicContentModel AddTopicContent(TopicContentModel c) {
		TopicContentModel cm= topiccontentrepo.save(c);
		return cm;
		
	}
	
	public ContentQuestionModel AddContentQuestion(ContentQuestionModel q) {
		ContentQuestionModel cq=contentquestionrepo.save(q);
		return cq;
	}
	
	
}
