package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

    @Query(value = "SELECT id_person AS id FROM person p WHERE p.email = :email", nativeQuery = true)
    Long findPersonsId(@Param("email") String email);

    @Query(value = "SELECT p.email FROM person p WHERE p.id = :id", nativeQuery = true)
    String findEmailById(@Param("id") Long id);

    @Query("SELECT p FROM Person p LEFT JOIN FETCH p.personHasRoleSet phr LEFT JOIN FETCH phr.role r WHERE p.email = :email")
    Person findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Person p")
    List<Person> findAll();

    // LEFT JOIN FETCH p.contacts c
    @Query(value = "SELECT p FROM Person p LEFT JOIN FETCH p.contacts c",
            countQuery = "SELECT COUNT(p) FROM Person p")
    Page<Person> findAll(Pageable pageable);

//    @Query("SELECT p FROM Person p JOIN FETCH p. WHERE p.id = :id")
//    Optional<Person> findByIdWithRole(Long id);

//    @Query(value = "SELECT p FROM Person p JOIN FETCH p.address WHERE p.id = :id")
//    Optional<Person> findById(Long id);
}
