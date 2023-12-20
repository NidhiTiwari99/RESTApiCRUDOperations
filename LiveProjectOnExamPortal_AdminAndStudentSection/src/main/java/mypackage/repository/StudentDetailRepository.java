package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.StudentDetailModel;

public interface StudentDetailRepository extends JpaRepository<StudentDetailModel, Integer> {

}
