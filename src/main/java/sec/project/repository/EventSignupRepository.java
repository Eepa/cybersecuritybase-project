package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sec.project.domain.EventSignup;

import java.util.List;

public interface EventSignupRepository extends JpaRepository<EventSignup, Long> {

    List<EventSignup> findAll();

    @Query(value= "select * from Event_Signup es where es.name = ?1 and es.address = 'moi'", nativeQuery = true)
    List<EventSignup> findByName(String name);

}
