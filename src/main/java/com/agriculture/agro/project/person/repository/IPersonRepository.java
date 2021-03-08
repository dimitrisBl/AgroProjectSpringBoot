package com.agriculture.agro.project.person.repository;

import com.agriculture.agro.project.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository <Person, Long>{}
