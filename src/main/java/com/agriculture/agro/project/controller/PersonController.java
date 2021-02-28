package com.agriculture.agro.project.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriculture.agro.project.model.Person;
import com.agriculture.agro.project.service.PersonService;

/**
 * This complete CRUD rest controller for person.
 * If database is empty returns the empty json list ([]).
 *  
 * 
 * @author Dimitris
 *
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	
	
private final PersonService personService;
    
    /**
     * Initialize a PersonService object.
     * 	
     * @param personService
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    
    /**
     * POST METHOD
     * 
     * Adds a new person in database.
     * 
     * @param person.
     */
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }
    
    /**
     * GET METHOD
     * 
     * @return all persons.
     */
    @GetMapping( path = "/all")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    
    /**
     * GET BY ID 
     * 
     * ENDPOINT: http://localhost:8080/api/v1/person/THE-ID-HERE
     * 
     * @param id haves the person id.
     * @return a person with an ID received from the url.
     */
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
    
    /**
     * DELETE METHOD
     * 
     * ENDPOINT: http://localhost:8080/api/v1/person/THE-ID-HERE
     * 
     * This method delete user with id logic, the id obtained from the url.
     * @param id haves the id for any person.
     */
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
            personService.deletePerson(id);
    }
    
    /**
     * PUT METHOD
     * 
     * ENDPOINT: http://localhost:8080/api/v1/person/THE-ID-HERE
     * 
     * This method updates the data for a person with id logic. 
     * @param id the person id
     * @param personToUpdate is the person object which will updated 
     */
    @PutMapping( path = "{id}")
    public void updatePersonById(@PathVariable("id")UUID id, @Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

}
