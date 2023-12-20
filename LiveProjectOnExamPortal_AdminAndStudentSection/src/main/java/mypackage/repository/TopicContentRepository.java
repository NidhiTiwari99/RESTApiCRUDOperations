package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.TopicContentModel;



public interface TopicContentRepository extends JpaRepository<TopicContentModel, Integer>{

}
