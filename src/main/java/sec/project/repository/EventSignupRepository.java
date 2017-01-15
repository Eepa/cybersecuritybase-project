package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sec.project.domain.EventSignup;

import java.util.List;

public interface EventSignupRepository extends JpaRepository<EventSignup, Long> {

    List<EventSignup> findAll();

    @Query("SELECT es FROM EventSignup es WHERE es.name = :name")
    List<EventSignup> findByName(@Param("name") String name);

    void deleteByNameAndAddress(String name, String address);

}
