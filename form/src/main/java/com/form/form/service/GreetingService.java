package com.form.form.service;

import com.form.form.GreetingController.Greeting;
import com.form.form.Repository.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;

    public Greeting addgreeting(Greeting greeting) {
        greetingRepository.save(greeting);
        return greeting;
    }

    public Iterable<Greeting> getgreetings() {
        return greetingRepository.findAll();
    }
}