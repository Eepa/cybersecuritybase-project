package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.EventSignup;
import sec.project.repository.EventSignupRepository;

@Controller
public class EventSignupController {

    @Autowired
    private EventSignupRepository signupRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRootPage() {
        return "redirect:/eventsignups/new";
    }

    @RequestMapping(value = "/eventsignups", method = RequestMethod.GET)
    public String getEventSignups() {
        return "event_signups";
    }

    @RequestMapping(value = "/eventsignups/new", method = RequestMethod.GET)
    public String getNewEventSignupForm() {
        return "event_signups_form";
    }

    @RequestMapping(value = "/eventsignups", method = RequestMethod.POST)
    public String createEventSignup(@RequestParam String name, @RequestParam String address) {
        signupRepository.save(new EventSignup(name, address));
        return "redirect:/eventsignups?done";
    }

}
