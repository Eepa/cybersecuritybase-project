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
        return "redirect:/eventsignup";
    }

    @RequestMapping(value = "/eventsignup", method = RequestMethod.GET)
    public String loadForm() {
        return "event_signup_form";
    }

    @RequestMapping(value = "/eventsignup", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address) {
        signupRepository.save(new EventSignup(name, address));
        return "done";
    }

}
