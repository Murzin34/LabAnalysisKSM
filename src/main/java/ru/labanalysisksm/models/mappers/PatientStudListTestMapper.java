package ru.labanalysisksm.models.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;

import java.util.List;

//TODO Сделать мапы через мапстракт
@Component
@Mapper(componentModel = "spring", uses = PatientStudTestMapper.class)
public interface PatientStudListTestMapper {

    List<PatientStudTestDTO> toDtoList(List<PatientStud> patientStud);

    List<PatientStud> toEntityList(List<PatientStudTestDTO> patientStudTestDTOList);
}
