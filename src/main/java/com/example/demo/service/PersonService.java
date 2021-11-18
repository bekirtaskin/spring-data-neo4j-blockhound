package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;

import com.example.demo.dto.CreatePersonRequest;
import com.example.demo.dto.PersonResponse;
import com.example.demo.node.Person;
import com.example.demo.repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {
	private final PersonRepository personRepository;
	private final ModelMapper mapper;
	private final TransactionalOperator transactionalOperator;
	
	@PostConstruct
	void initData() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(null, "A", "B", new Date()));
		personList.add(new Person(null, "C", "D", new Date()));
		personRepository.saveAll(personList).subscribe();
	}

	/**
	 * transactional
	 * 
	 * @param createRequest
	 * @return
	 */
	public Mono<String> save(@Valid Mono<CreatePersonRequest> createRequest) {
		Mono<String> savePerson = createRequest
				.map(r -> mapper.map(r, Person.class))
				.flatMap(personRepository::save)
				.map(Person::getIdentity);
		return transactionalOperator.transactional(savePerson);
	}

	public Flux<PersonResponse> loadAll() {
		return personRepository.loadAll();
	}
}
