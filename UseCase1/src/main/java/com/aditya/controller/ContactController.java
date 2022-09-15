
package com.aditya.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.exception.ResourceNotFoundException;
import com.aditya.model.Person;
import com.aditya.repository.ContactRepository;
import com.aditya.service.ContactService;


@RestController
@RequestMapping("/contact")
public class ContactController {

  @Autowired
 
  ContactService contactService;
  
  @PostMapping("/save")
  public ResponseEntity<Person> save(@RequestBody Person contact) {
      Person _contact = contactService.save(contact);

      return new ResponseEntity<>(_contact, HttpStatus.CREATED);
  }

  @GetMapping("/retrieve/{id}")
  public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
	    Person person = contactService.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Contact with id = " + id));

	    return new ResponseEntity<>(person, HttpStatus.OK);
  }




 
}


