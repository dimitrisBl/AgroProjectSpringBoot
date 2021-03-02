package com.agriculture.agro.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.agriculture.agro.project.model.Person;

public interface IPersonRepository extends JpaRepository <Person, Long>{

}
