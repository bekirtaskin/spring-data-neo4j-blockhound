package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreatePersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("people")
@RequiredArgsConstructor
@RequestMapping("/people")
@Validated
public class PersonController {

	private final PersonService personService;

	@PostMapping
	public Mono<String> savePerson(@RequestBody @Valid Mono<CreatePersonRequest> createRequest) {
		return personService.save(createRequest);
	}
	
	@GetMapping
	public Flux<PersonResponse> loadAll(){
		return personService.loadAll();
	}
}
