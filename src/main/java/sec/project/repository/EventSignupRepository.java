package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.EventSignup;

import java.util.List;

public interface EventSignupRepository extends JpaRepository<EventSignup, Long> {

    List<EventSignup> findAll();

}
