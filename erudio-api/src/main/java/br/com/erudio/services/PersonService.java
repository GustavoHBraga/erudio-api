package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> listAll(){
		
		logger.info("Finding all people");
		List<Person> peoples = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			peoples.add(person);
		}
		
		return peoples;
	}
	public Person findById(String id){
		
		logger.info("Finding one Person");
		
		return mockPerson(1);
	}
	
	public Person create(Person person){
		
		logger.info("Creating Person ");
		
		return person;
	}
	
	public Person update(Person person){
		
		logger.info("Update Person ");
		
		return person;
	}

	public void delete(String id){
		
		logger.info("Delete Person ");
		
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}
	
}
