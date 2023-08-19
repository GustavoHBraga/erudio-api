package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.utils.MathUtils;

@RestController
public class MathController extends MathUtils{
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)	
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo){
		
		checkTwoNumbers(numberOne,numberTwo);
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method = RequestMethod.GET)	
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo){
		
		checkTwoNumbers(numberOne,numberTwo);
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/dividedBy/{numberOne}/{numberTwo}",method = RequestMethod.GET)	
	public Double dividedBy(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo){
		
		checkTwoNumbers(numberOne,numberTwo);
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/multipledBy/{numberOne}/{numberTwo}",method = RequestMethod.GET)	
	public Double multipledBy(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo){
		
		checkTwoNumbers(numberOne,numberTwo);
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",method = RequestMethod.GET)	
	public Double average(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo){
		
		checkTwoNumbers(numberOne,numberTwo);
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}
	
	@RequestMapping(value = "/sqrt/{numberOne}",method = RequestMethod.GET)	
	public Double sqrt(@PathVariable(value = "numberOne") String numberOne){
		
		checkSigleNumber(numberOne);
		return Math.sqrt(convertToDouble(numberOne));
	}
}
