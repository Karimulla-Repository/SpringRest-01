package com.rest.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private HttpStatus httpStatus;
	

}
