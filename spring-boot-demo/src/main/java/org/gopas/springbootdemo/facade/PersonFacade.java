package org.gopas.springbootdemo.facade;

import org.gopas.springbootdemo.annotations.IsAdmin;
import org.gopas.springbootdemo.annotations.TrackTime;
import org.gopas.springbootdemo.api.PersonBasicViewDto;
import org.gopas.springbootdemo.api.PersonCreateDto;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.exceptions.ResourceNotCreatedException;
import org.gopas.springbootdemo.exceptions.ResourceNotFoundException;
import org.gopas.springbootdemo.service.AuthService;
import org.gopas.springbootdemo.service.PersonService;
import org.gopas.springbootdemo.service.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonFacade {
    private final PersonService personService;
    private final PersonMapper personMapper;
    private final AuthService authService;

    @Autowired
    public PersonFacade(PersonService personService, PersonMapper personMapper, AuthService authService) {
        this.personService = personService;
        this.personMapper = personMapper;
        this.authService = authService;
    }

    public PersonDetailedViewDto findById(Long id) {
        try {
            Person person = personService.findById(id);
            return personMapper.mapToDetailedView(person);
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Person with id: " + id + " was not found.");
        }
    }

    @PreAuthorize("hasAuthority('USER') and @authService.authUsername() == 'radek.kruta@seznam.cz'")
    public void createPerson(PersonCreateDto personCreateDto) {
        // if security logic is too complicated to it within the method
        Person person = personMapper.createMapToEntity(personCreateDto);
        try {
            personService.createPerson(person);
        } catch (DataAccessException dataAccessException) {
            throw new ResourceNotCreatedException("Person was not created");
        }
    }

    @TrackTime
    @IsAdmin
    public List<PersonBasicViewDto> findAll() {
        // call 2,3,4
        return personMapper.mapToListBasicView(personService.findAll());
    }

    @Cacheable(value = "persons", sync = true, condition = "#pageable !=null")
    @PreAuthorize("hasAuthority('USER')")
    @Transactional
    public Page<PersonBasicViewDto> findAllPageable(Pageable pageable) {
        // findAll  from service
        Page<Person> page = personService.findAllPageable(pageable);
        return personMapper.mapToPageBasicView(page);
    }
}
