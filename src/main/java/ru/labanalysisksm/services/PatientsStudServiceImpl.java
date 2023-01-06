package ru.labanalysisksm.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;
import ru.labanalysisksm.repositories.PatientsStudRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PatientsStudServiceImpl implements PatientsStudService {
    private final PatientsStudRepository patientsStudRepository;

    public PatientsStudServiceImpl(PatientsStudRepository patientsStudRepository) {
        this.patientsStudRepository = patientsStudRepository;
    }

    public List<PatientStud> findAllPatients() {
        return patientsStudRepository.findAll();
    }

    public PatientStud findOnePatients(int id) {
        Optional<PatientStud> findOnePatient = patientsStudRepository.findById(id);
        return findOnePatient.orElse(null);
    }

    @Transactional
    public void save(PatientStud patientStud) {
        patientsStudRepository.save(patientStud);
    }

    @Transactional
    public void update(int id, PatientStud updatedPatientStud) {
        updatedPatientStud.setId(id);
        patientsStudRepository.save(updatedPatientStud);
    }

    @Transactional
    public void delete(int id) {
        patientsStudRepository.deleteById(id);
    }

    public void summarize(PatientStudTestDTO patientStudTestDTO) {
        int local_sum = 0;
        if (patientStudTestDTO.isCytologyTOR()) {
            local_sum += 268;
        }
        if (patientStudTestDTO.isHivTOR()) {
            local_sum += 281;
        }
        if (patientStudTestDTO.isSyphilisTOR()) {
            local_sum += 282;
        }
        if (patientStudTestDTO.isCoroutineTOR()) {
            local_sum += 459;
        }
        if (patientStudTestDTO.isHelminthTOR()) {
            local_sum += 228;
        }
        if (patientStudTestDTO.isHepatitisBTOR()) {
            local_sum += 223;
        }
        if (patientStudTestDTO.isHepatitisCTOR()) {
            local_sum += 223;
        }
        if (patientStudTestDTO.isVidalTOR()) {
            local_sum += 685;
        }
        patientStudTestDTO.setSum(local_sum);
    }

    //TODO Мапа через мапстракт
/*
    public List<PatientStudTestDTO> findAllPatients() {
        return patientStudListTestMapper.toDtoList(patientsStudRepository.findAll());
    }
 */
}
