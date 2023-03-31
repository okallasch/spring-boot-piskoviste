package org.gopas.springbootdemo.service.mappers;

import org.gopas.springbootdemo.api.PersonBasicViewDto;
import org.gopas.springbootdemo.api.PersonCreateDto;
import org.gopas.springbootdemo.api.PersonDetailedViewDto;
import org.gopas.springbootdemo.data.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings( // if needed to remap fields with different names
            @Mapping(source = "id", target = "id")
    )
    PersonDetailedViewDto mapToDetailedView(Person person);

    Person createMapToEntity(PersonCreateDto person);

    List<PersonBasicViewDto> mapToListBasicView(List<Person> person);

    PersonBasicViewDto mapToBasicView(Person person);

    default Page<PersonBasicViewDto> mapToPageBasicView(Page<Person> pagePerson) {
        return pagePerson.map(this::mapToBasicView);
    }


}
