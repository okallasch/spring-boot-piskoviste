package org.gopas.springbootdemo.service;

import org.gopas.springbootdemo.annotations.IsAdmin;
import org.gopas.springbootdemo.annotations.TrackTime;
import org.gopas.springbootdemo.api.PersonBasicViewDto;
import org.gopas.springbootdemo.api.PersonCreateDto;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.data.model.Person;
import org.gopas.springbootdemo.data.repository.PersonRepository;
import org.gopas.springbootdemo.exceptions.ResourceNotCreatedException;
import org.gopas.springbootdemo.exceptions.ResourceNotFoundException;
import org.gopas.springbootdemo.service.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
//    @Autowired
//    @Lazy
//    private PersonService self; // NEVER do this!!!!

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @PostConstruct
    public void print() {
        System.out.println("PersonService bean was created.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PersonService bean was destroyed.");
    }

    public Person findById(Long id) {
        try {
            Person person = personRepository.findByIdWithAddress(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Person with id: " + id + " was not found."));
            return person;
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Person with id: " + id + " was not found.");
        }
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> findAll() {
        // call 2,3,4
        return personRepository.findAll();
    }

    public Page<Person> findAllPageable(Pageable pageable) {
//        self.findAll();
        return personRepository.findAll(pageable);
    }

}
