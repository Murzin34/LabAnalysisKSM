package ru.labanalysisksm.services;

import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;

import java.util.List;

public interface PatientsStudService {
    public List<PatientStud> findAllPatients();

    public PatientStud findOnePatients(int id);

    public void save(PatientStud patientStud);

    public void update(int id, PatientStud updatedPatientStud);

    public void delete(int id);

    public void summarize(PatientStudTestDTO patientStudTestDTO);
}
