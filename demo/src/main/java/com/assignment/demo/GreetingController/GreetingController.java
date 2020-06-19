package com.assignment.demo.GreetingController;

import com.assignment.demo.Repository.GreetingRepository;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GreetingController {

    // @GetMapping("/greeting")
    // public String greetingForm(Model model) {
    // model.addAttribute("greeting", new Greeting());
    // return "greeting";
    // }

    // @PostMapping("/greeting")
    // public String greetingSubmit(@ModelAttribute Greeting greeting) {

    // return "result";
    // }

    @Autowired
    private GreetingRepository greetingRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String greetingSubmit(@RequestParam long id, @RequestParam String content) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Greeting greeting = new Greeting();
        greeting.setId(id);
        greeting.setContent(content);
        greetingRepository.save(greeting);
        return "saved";
    }

    @GetMapping(path = "/greeting")
    public @ResponseBody Iterable<Greeting> greetingForm() {
        return greetingRepository.findAll();
    }
}