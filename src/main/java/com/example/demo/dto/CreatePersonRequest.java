package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

	@NotBlank
	@Schema(example = "Bekir")
	private String name;
	
	@NotBlank
	@Schema(example = "Taskin")
	private String surname;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Schema(example = "01-01-1881", pattern = "/([0-9]{4})-(?:[0-9]{2})-([0-9]{2})/")
	private Date birthday;
}
