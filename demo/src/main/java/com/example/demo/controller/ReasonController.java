package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "reason", description = "the Person API")
@RequestMapping("/reason")
@RestController
public class ReasonController {

	@Autowired
	private PersonRepository personRepository;
	
	 @Operation(summary = "Get person", description = "Returns a person Object", tags = { "Get Request" })
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id) {
		Optional<Person> person = personRepository.findById(id);
		return new ResponseEntity<>(person.get(), HttpStatus.OK);
	}

}
