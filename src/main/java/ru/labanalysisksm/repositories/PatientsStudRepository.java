package ru.labanalysisksm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.labanalysisksm.models.entities.PatientStud;

@Repository
public interface PatientsStudRepository extends JpaRepository<PatientStud, Integer> {

}
