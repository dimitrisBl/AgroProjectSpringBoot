package com.agriculture.agro.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * TODO CLASS DESCRIPTION
 * 
 * @author Dimitris
 *
 */
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
    
    @NotBlank
    @Column(name = "points")
    private String points;
    
    /**
     * Default constructor.
     */
    public Person() {
    	super();
    }
    
    /**
     * Instantiate a new Person
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName,String lastName) {
    	super();
		this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * 
     * @return the person id.
     */
	public long getId() {
		return id;
	}
    
    
	/**
	 * 
	 * @return person name.
	 */
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @return person lastName.
	 */
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}


	/**
	 * Set person name 
	 * 
	 * @param firstName has the name of the person.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * Set person lastName
	 * 
	 * @param lastName has the lastName of the person.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}	
