package ru.labanalysisksm.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;

//TODO Сделать мапы через мапстракт
@Component
@Mapper(componentModel = "spring")
public interface PatientStudTestMapper {

    PatientStudTestDTO toDTO(PatientStud patientStud);

    PatientStud toEntity(PatientStudTestDTO patientStudTestDTO);
}