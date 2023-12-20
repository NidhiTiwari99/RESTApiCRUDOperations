package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.ExamDetailModel;

public interface ExamDetailRepository extends JpaRepository<ExamDetailModel, Integer>{

}
