package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.TopicModel;

public interface TopicRepository extends JpaRepository<TopicModel, Integer>{

}
