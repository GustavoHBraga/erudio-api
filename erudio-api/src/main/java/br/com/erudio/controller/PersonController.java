package br.com.erudio.controller;

import java.util.List;

import br.com.erudio.data.vo.v3.PersonVOV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import br.com.erudio.utils.MediaType;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<PersonVO> findall() {
		return personService.listAll();
	}
	
	@GetMapping(value = "/{id}",
				produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PersonVO sourceById(@PathVariable(value = "id") long id) {
		return personService.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
				 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonVO create(@RequestBody PersonVO person) {
		return personService.create(person);
	}
	
	@PostMapping(
			value = "/v2",
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonVOV2 createV2 (@RequestBody PersonVOV2 person) {
		return personService.createV2(person);
	}
	@PostMapping(
			value = "/v3",
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonVOV3 createV3 (@RequestBody PersonVOV3 person) {
		return personService.createV3(person);
	}

	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			 	produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PersonVO update(@RequestBody PersonVO person) {
		return personService.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
