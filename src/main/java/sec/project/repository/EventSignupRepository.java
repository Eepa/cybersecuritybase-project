package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.EventSignup;

public interface EventSignupRepository extends JpaRepository<EventSignup, Long> {

}
