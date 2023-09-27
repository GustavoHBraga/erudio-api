package br.com.erudio.services;


import java.util.List;
import java.util.logging.Logger;

import br.com.erudio.data.vo.v3.PersonVOV3;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper personMapper;
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<PersonVO> listAll(){
		
		logger.info("Finding all people");
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
	}
	public PersonVO findById(Long id){
		
		logger.info("Finding one Person");
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonVO.class);
		
	}
	
	public PersonVO create(PersonVO personVO){
		
		logger.info("Creating Person ");
		var entity = DozerMapper.parseObject(personVO,Person.class);
		var entityVO = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
		return entityVO;
	}
	
	// New function to create a new person to API V2.0
	public PersonVOV2 createV2(PersonVOV2 personVO2){
		
		logger.info("Creating Person V2 ");
		var entity = personMapper.convertVoTOEntity(personVO2);
		var entityVO = personMapper.convertEntityToVo(personRepository.save(entity));
		return entityVO;
	}
	public PersonVOV3 createV3(PersonVOV3 personVO3){

		logger.info("Creating Person V3");
		var entity = personMapper.convertVoTOEntityV3(personVO3);
		var entityVO = personMapper.convertEntityToVoV3(personRepository.save(entity));
		return entityVO;
	}

	public PersonVO update(PersonVO personVO){
		
		logger.info("Update Person ");
		var entityPerson = DozerMapper.parseObject(personVO, Person.class);
		
		var personFilter = personRepository.findById(entityPerson.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		BeanUtils.copyProperties(entityPerson, personFilter,"id");
		
		return DozerMapper.parseObject(this.personRepository.save(personFilter), PersonVO.class);
	}

	public void delete(Long id){
		
		logger.info("Delete Person ");
		personRepository.deleteById(id);
	}
	
}
