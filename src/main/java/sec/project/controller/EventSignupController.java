package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.EventSignup;
import sec.project.repository.EventSignupRepository;

import java.util.List;

@Controller
public class EventSignupController {

    @Autowired
    private EventSignupRepository eventSignupRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRootPage() {
        return "redirect:/eventsignups";
    }

    @RequestMapping(value = "/eventsignups", method = RequestMethod.GET)
    public String getEventSignups(Model model) {
        model.addAttribute("eventsignups", eventSignupRepository.findAll());
        return "event_signups";
    }

    @RequestMapping(value = "/eventsignups/new", method = RequestMethod.GET)
    public String getNewEventSignupForm() {
        return "event_signups_form";
    }

    @RequestMapping(value = "/eventsignups", method = RequestMethod.POST)
    public String createEventSignup(@RequestParam String name, @RequestParam String address) {
        eventSignupRepository.save(new EventSignup(name, address));
        return "redirect:/eventsignups?done";
    }

    @RequestMapping(value = "/eventsignups/search", method = RequestMethod.POST)
    public String searchEventSignup(@RequestParam String name, Model model) {
        List<EventSignup> eventSignups = eventSignupRepository.findByName(name);
        model.addAttribute("eventsignups", eventSignups);
        return "event_signups";
    }

}
