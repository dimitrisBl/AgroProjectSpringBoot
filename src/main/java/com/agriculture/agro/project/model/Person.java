package com.agriculture.agro.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table( name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	
    @NotBlank
    @Column(name = "first_name")
    private  String firstName;
    
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    
    
    public Person() {
    	super();
    }

    public Person(@JsonProperty("name") String firstName, @JsonProperty("last") String lastName) {
    	super();
		this.firstName = firstName;
        this.lastName = lastName;
    }

    
	public long getId() {
		return id;
	}
    
    
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}	
