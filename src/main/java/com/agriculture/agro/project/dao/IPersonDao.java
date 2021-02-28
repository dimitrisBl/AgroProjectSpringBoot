package com.agriculture.agro.project.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.agriculture.agro.project.model.Person;

public interface IPersonDao {
		
	 	int insertPerson(UUID id, Person person);

	    int deletePersonById(UUID id);

	    int updatePersonById(UUID id, Person person);

	    Optional<Person> selectPersonById(UUID id);

	    default int insertPerson(Person person){
	        UUID id = UUID.randomUUID();
	        return insertPerson(id,person);
	    }
	    
	    Person selectAllPersons();
}
