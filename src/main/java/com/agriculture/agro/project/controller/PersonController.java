package com.agriculture.agro.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.agro.project.exception.ResourceNotFoundException;
import com.agriculture.agro.project.model.Person;
import com.agriculture.agro.project.repository.IPersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * This complete CRUD rest controller for person.
 * If database is empty returns the empty json list ([]).
 *  
 * 
 * @author Dimitris
 *
 */
@RequestMapping("/api/person")
@RestController
public class PersonController {
		
	
	@Autowired
	private IPersonRepository personRepository;
		
	
	/**
	 * GET METHOD
	 * 
	 * @return all persons.
	 */
	@GetMapping()
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	
	/**
	 * GET BY ID METHOD
	 * 
	 * @param personId
	 * @return person with current id.
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + personId));
		return ResponseEntity.ok().body(person);
	}
	
	/**
	 * POST METHOD
	 * 
	 * @param person
	 * @return a new person
	 */
	@PostMapping()
	public Person createPerson(@Valid @NotNull @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	/**
	 * UPDATE METHOD
	 *  
	 * This method updates the data for a person with id logic.
	 *  
	 * @param personId has the person id.
	 * @param person
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping(path = "{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
												@Valid @RequestBody Person person) throws ResourceNotFoundException{
		
		Person entity = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + personId));
		
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setPoints(person.getPoints());
		
		return ResponseEntity.ok(this.personRepository.save(entity));
	}
	
	/**
	 * DELETE METHOD
	 * 
	 * This method delete user with id logic, the id obtained from the URL.
	 * 
	 * @param personId has the person id.
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping(path = "{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId) throws ResourceNotFoundException{
		
		Person entity = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + personId));
		
		this.personRepository.delete(entity);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Person with id "+personId+" deleted. ",Boolean.TRUE);
		
		return response;
	}
}
