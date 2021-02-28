package com.agriculture.agro.project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.agriculture.agro.project.dao.IPersonDao;
import com.agriculture.agro.project.model.Person;

@Service
public class PersonService {

	
	private final IPersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") IPersonDao personDao){
        this.personDao = personDao;
    }
    
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons(){
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(UUID id){
            return personDao.selectPersonById(id);
    }
    
    public int deletePerson(UUID id){
       return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person){
        return personDao.updatePersonById(id, person);
    }

}
