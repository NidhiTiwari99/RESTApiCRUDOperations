package mypackage.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mypackage.model.*;
public interface DummyRepository extends JpaRepository<TopicModel, Integer> {

	@Query(value = "select u.topic_id,u.topic_name,u.flag from tbltopics u where u.flag=0 and u.topic_id=?#{[0]}", nativeQuery = true)
	public List<TopicModel>GetAllTopics(int id);
}
