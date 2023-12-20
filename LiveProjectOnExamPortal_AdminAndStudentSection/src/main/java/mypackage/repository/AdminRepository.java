package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, Integer>{

}
