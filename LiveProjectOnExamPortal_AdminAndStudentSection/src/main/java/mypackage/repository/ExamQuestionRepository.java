package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.ExamQuestionModel;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestionModel, Integer>{

}
