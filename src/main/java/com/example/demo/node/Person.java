package com.example.demo.node;

import java.util.Date;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Node({ "Person" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String identity;
	
	@Property
    private String name;
	
	@Property
	private String surname;
	
	@Property
    private Date birthday;
}
