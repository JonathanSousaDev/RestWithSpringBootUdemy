package com.udemy.restwithspringbootudemy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restwithspringbootudemy.converters.NumberConverter;
import com.udemy.restwithspringbootudemy.exception.UnsuportedMathOperationException;
import com.udemy.restwithspringbootudemy.math.SimpleMath;

@RestController
public class PersonController {

	private SimpleMath math = new SimpleMath();

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.covertToDouble(numberOne), NumberConverter.covertToDouble(numberTwo));		
	}

}
