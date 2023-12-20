package mypackage.controller;
import mypackage.model.*;
import mypackage.services.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")

public class TopicTopicContentAndQuestionApiController {

	@Autowired
	TopicTopicContentAndQuestionService topiccontentservice;
	
	
	@GetMapping("api/topic")
	public List<TopicModel>getTopics(){
		return topiccontentservice.GetTopics();
	}
	
	@GetMapping("api/topic/{id}")
	public TopicModel GetTopicById(@PathVariable("id") int id) {
		return topiccontentservice.GetTopic(id);
	}
	
	@GetMapping("api/topiccontent/{id}")
	public List<TopicContentModel> getTopicContent(@PathVariable("id") int id){
		return topiccontentservice.GetTopicContent(id);
	}
	@GetMapping("api/topiccontent")
	public List<TopicContentModel>getTopicContents(){
		return topiccontentservice.GetTopicContents();
	}
	
	@GetMapping("api/contentquestion")
	public List<ContentQuestionModel>getContentQuestions(){
		return topiccontentservice.GetContentQuestions();
	}
	
	@PostMapping("api/topic")
	public TopicModel AddTopic(@RequestBody TopicModel t){
		return topiccontentservice.AddTopic(t);
	}
	
	@PostMapping("api/topiccontent")
	public TopicContentModel AddTopiContent(@RequestBody TopicContentModel c){
		return topiccontentservice.AddTopicContent(c);
	}
	
	@PostMapping ("api/contentquestion")
	public ContentQuestionModel AddContentQuestion(@RequestBody ContentQuestionModel q) {
		return topiccontentservice.AddContentQuestion(q);
	}
	
	@DeleteMapping("api/topic/{id}")
	public TopicModel DeleteTopic(@PathVariable("id")int id) {
	return topiccontentservice.DeleteTopic(id);
}

	
	@PutMapping("api/topic")
	public TopicModel UpdateTopic(@RequestBody TopicModel sq) {
	return topiccontentservice.UpdateTopic(sq);
}
	
	@DeleteMapping("api/topiccontent/{id}")
	public TopicContentModel DeleteContent(@PathVariable("id")int id) {
	return topiccontentservice.DeleteTopicContent(id);
}
	
	@PutMapping("api/topiccontent")
	public TopicContentModel UpdateContent(@RequestBody TopicContentModel sq) {
	return topiccontentservice.UpdateTopicContent(sq);
}
}
