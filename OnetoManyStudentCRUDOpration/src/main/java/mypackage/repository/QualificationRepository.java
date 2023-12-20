package mypackage.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.*;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

}
