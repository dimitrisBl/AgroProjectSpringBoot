package com.agriculture.agro.project.area.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table( name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Column(name = "description")
    private  String description;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "points")
    private double points;

    /**
     * Default constructor.
     */
    public Area() {
        super();
    }



    /**
     * Instantiate a new Area
     *
     * @param description
     * @param name
     */
    public Area(String description,String name, double points) {
        super();
        this.description = description;
        this.name = name;
       // this.points = points;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     * Set area description
     *
     * @param description has the name of the person.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Set area name
     *
     * @param name has the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "points", nullable = false)
    public double getPoints() {
        return points;
    }
}
