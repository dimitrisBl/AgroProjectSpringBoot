package com.agriculture.agro.project.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.agriculture.agro.project.model.Person;


@Repository("postgres")
public class PersonDataAccessService implements IPersonDao{

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Person> selectAllPersons() {
		// TODO Auto-generated method stub
		return List.of(new Person(UUID.randomUUID(), "This is from postgres database"));
	}

}
