package com.example.demo.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.demo.dto.PersonResponse;
import com.example.demo.node.Person;

import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveNeo4jRepository<Person, String> {

	@Query("MATCH (p:Person) "
			+ "RETURN p{identity: p.identity, name: p.name}, "
				+ "COUNT(p) as totalCount")
	Flux<PersonResponse> loadAll();

}
