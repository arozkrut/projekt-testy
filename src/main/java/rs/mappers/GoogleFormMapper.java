package rs.mappers;

import domain.models.GoogleForm;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import rs.models.GoogleFormCreateDTO;
import rs.models.GoogleFormDTO;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GoogleFormMapper {
    GoogleFormDTO mapToDTO(GoogleForm googleForm);

    @Mapping(target = "id", ignore = true)
    GoogleForm mapToEntity(GoogleFormCreateDTO googleFormCreateDTO);

    @Mapping(target = "id", ignore = true)
    GoogleForm updateGoogleFormFromDTO(GoogleFormCreateDTO googleFormCreateDTO, @MappingTarget GoogleForm googleForm);
}
