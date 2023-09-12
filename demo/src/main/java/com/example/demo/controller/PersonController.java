package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

import io.swagger.v3.oas.annotations.Operation;

//@Tag(name = "person", description = "the Person API")
@RequestMapping("/person")
@RestController
public class PersonController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PersonRepository personRepository;

	@Operation(summary = "Get person", description = "Returns a person Object", tags = { "Get Request" })
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id) {
		java.util.Optional<Person> person = personRepository.findById(id);
		return new ResponseEntity<>(person.get(), HttpStatus.OK);
	}

	@Operation(summary = "Saves a person", description = "Saves a person Object", tags = { "Post Request" })
	@PostMapping("/add")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
	}

	@Operation(summary = "Get the school of a person", description = "Gets school", tags = { "Get Request" })
	@GetMapping("/getSchool/{id}")
	public String getSchoolDetails(@PathVariable int id) {
		String url = "http://localhost:8080/school/" + id;
		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
		return res.getBody();
	}

}
