package sec.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sec.project.domain.EventSignup;
import sec.project.repository.EventSignupRepository;

@Service
public class EventSignupService {

    @Autowired
    private EventSignupRepository eventSignupRepository;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void saveEventSignup(String name, String address) {
        eventSignupRepository.save(new EventSignup(name, address));
    }

}
