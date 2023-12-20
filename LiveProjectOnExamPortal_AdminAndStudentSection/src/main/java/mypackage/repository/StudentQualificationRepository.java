package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.StudentQualificationModel;

public interface StudentQualificationRepository extends JpaRepository<StudentQualificationModel, Integer>{

}
