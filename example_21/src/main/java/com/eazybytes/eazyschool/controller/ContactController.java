package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

//    @PostMapping(value = "/saveMsg")
//    public ModelAndView saveMessage(@RequestParam(name="name") String myCustomvarName, @RequestParam String mobileNum,
//            @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        log.info("Name: " + myCustomvarName);
//        log.info("Mobile Number: " + mobileNum);
//        log.info("email: " + email);
//        log.info("subject: " + subject);
//        log.info("message: " + message);
//        return new ModelAndView("redirect:/contact");
//    }

    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(Contact contact) {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
