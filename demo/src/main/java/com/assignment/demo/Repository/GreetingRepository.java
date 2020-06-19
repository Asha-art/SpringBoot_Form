package com.assignment.demo.Repository;

import java.util.List;

import com.assignment.demo.GreetingController.Greeting;

import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository {
    List<Greeting> findById(long id);
}