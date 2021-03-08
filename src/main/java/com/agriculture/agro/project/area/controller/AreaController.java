package com.agriculture.agro.project.area.controller;

import com.agriculture.agro.project.area.model.Area;
import com.agriculture.agro.project.area.repository.IAreaRepository;
import com.agriculture.agro.project.exception.ResourceNotFoundException;
import com.agriculture.agro.project.person.model.Person;
import com.agriculture.agro.project.person.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/person")
@RestController
public class AreaController {


    @Autowired
    private IAreaRepository iAreaRepository;


    /**
     * GET METHOD
     *
     * @return all Areas.
     */
    @GetMapping()
    public List<Area> getAllPersons() {
        return iAreaRepository.findAll();
    }


    /**
     * GET BY ID METHOD
     *
     * @param areaId
     * @return person with current id.
     * @throws ResourceNotFoundException
     */
    @GetMapping(path = "{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable(value = "id") Long areaId)
            throws ResourceNotFoundException {
        Area area = iAreaRepository.findById(areaId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + areaId));
        return ResponseEntity.ok().body(area);
    }

    /**
     * POST METHOD
     *
     * @param area
     * @return a new area
     */
    @PostMapping()
    public Area createArea(@Valid @NotNull @RequestBody Area area) {
        return iAreaRepository.save(area);
    }

    /**
     * UPDATE METHOD
     * <p>
     * This method updates the data for an area with id logic.
     *
     * @param areaId has the area id.
     * @param area
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "{id}")
    public ResponseEntity<Area> updateArea(@PathVariable(value = "id") Long areaId,
                                           @Valid @RequestBody Area area) throws ResourceNotFoundException {

        Area entity = iAreaRepository.findById(areaId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + areaId));


        entity.setDescription(area.getDescription());
        entity.setName(area.getName());

        return ResponseEntity.ok(this.iAreaRepository.save(entity));
    }

    /**
     * DELETE METHOD
     * <p>
     * This method delete area with id logic, the id obtained from the URL.
     *
     * @param areaId has the areas id.
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(path = "{id}")
    public Map<String, Boolean> deleteArea(@PathVariable(value = "id") Long areaId) throws ResourceNotFoundException {

        Area entity = iAreaRepository.findById(areaId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + areaId));

        this.iAreaRepository.delete(entity);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Person with id " + areaId + " deleted. ", Boolean.TRUE);

        return response;
    }
}