package org.gopas.springbootdemo.rest;

import org.gopas.springbootdemo.api.PersonBasicViewDto;
import org.gopas.springbootdemo.api.PersonCreateDto;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.facade.PersonFacade;
import org.gopas.springbootdemo.service.PersonService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonRestController {

    private final PersonFacade personFacade;

    @Autowired
    public PersonRestController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @GetMapping(path = "/{id}")
    public PersonDetailedViewDto findById(@PathVariable("id") Long id) {
        return personFacade.findById(id);
    }

    @GetMapping
    public List<PersonBasicViewDto> findAll() {
        return personFacade.findAll();
    }

    @GetMapping(path = "/pageable")
//    public Page<PersonBasicViewDto> findAllPageable(@RequestParam("size") Long size,
//                                                    @RequestParam("page") Long page) {
    public Page<PersonBasicViewDto> findAllPageable(@ParameterObject Pageable pageable) {
        return personFacade.findAllPageable(pageable);
    }

    @PostMapping
    public void createPerson(@RequestBody @Valid PersonCreateDto personCreateDto) {
        personFacade.createPerson(personCreateDto);
    }

}
