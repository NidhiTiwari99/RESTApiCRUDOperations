package mypackage.services;

import mypackage.model.*;
import mypackage.repository.DummyRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

	@Autowired
	DummyRepository repo;

public List<TopicModel>GetTopics(int id){
	return repo.GetAllTopics(id);
}
}
