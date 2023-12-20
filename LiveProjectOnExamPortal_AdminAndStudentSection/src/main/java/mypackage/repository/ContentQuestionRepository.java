package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.ContentQuestionModel;

public interface ContentQuestionRepository extends JpaRepository<ContentQuestionModel, Integer>{

}
