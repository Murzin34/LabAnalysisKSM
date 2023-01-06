package ru.labanalysisksm.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;
import ru.labanalysisksm.services.PatientsStudService;
import ru.labanalysisksm.services.PatientsStudServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients/stud")
public class PatientStudRestController {
    private final PatientsStudService patientsStudService;
    private final ModelMapper modelMapper;

    public PatientStudRestController(PatientsStudServiceImpl patientsStudService, ModelMapper modelMapper) {
        this.patientsStudService = patientsStudService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<PatientStudTestDTO>> findAllPatients() {
        return new ResponseEntity<>(patientsStudService.findAllPatients().stream().map(this::convertToDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientStud> findOnePatient(@PathVariable Integer id) {
        return new ResponseEntity<>(patientsStudService.findOnePatients(id), HttpStatus.OK);
    }

    @PostMapping("/add") //TODO Обработать ошибку создания пациента
    public ResponseEntity<HttpStatus> createPatient(@RequestBody PatientStudTestDTO patientStudTestDTO) {
        patientsStudService.summarize(patientStudTestDTO);
        patientsStudService.save(convertToEntity(patientStudTestDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> updatePatient(@RequestBody PatientStudTestDTO patientStudTestDTO,
                                                    @PathVariable Integer id) {
        PatientStudTestDTO updatedPatientStudTestDTO = convertToDTO(patientsStudService.findOnePatients(id));
        updatedPatientStudTestDTO.setPatientName(patientStudTestDTO.getPatientName());
        updatedPatientStudTestDTO.setLocalDate(patientStudTestDTO.getLocalDate());
        updatedPatientStudTestDTO.setCytologyTOR(patientStudTestDTO.isCytologyTOR());
        updatedPatientStudTestDTO.setHivTOR(patientStudTestDTO.isHivTOR());
        updatedPatientStudTestDTO.setSyphilisTOR(patientStudTestDTO.isSyphilisTOR());
        updatedPatientStudTestDTO.setCoroutineTOR(patientStudTestDTO.isCoroutineTOR());
        updatedPatientStudTestDTO.setHelminthTOR(patientStudTestDTO.isHelminthTOR());
        updatedPatientStudTestDTO.setHepatitisBTOR(patientStudTestDTO.isHepatitisBTOR());
        updatedPatientStudTestDTO.setHepatitisCTOR(patientStudTestDTO.isHepatitisCTOR());
        updatedPatientStudTestDTO.setVidalTOR(patientStudTestDTO.isVidalTOR());
        patientsStudService.summarize(patientStudTestDTO);
        updatedPatientStudTestDTO.setSum(patientStudTestDTO.getSum());
        patientsStudService.update(id, convertToEntity(updatedPatientStudTestDTO));
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable Integer id) {
        patientsStudService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=KSM_Stud.xlsx";
        response.setHeader(headerKey, headerValue);
        patientsStudService.exportCustomerToExcel(response);
    }

    private PatientStud convertToEntity(PatientStudTestDTO patientStudTestDTO) {
        return modelMapper.map(patientStudTestDTO, PatientStud.class);
    }

    private PatientStudTestDTO convertToDTO(PatientStud patientStud) {
        return modelMapper.map(patientStud, PatientStudTestDTO.class);
    }
}