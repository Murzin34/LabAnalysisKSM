/*package ru.labanalysisksm.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.labanalysisksm.models.dto.PatientStudTestDTO;
import ru.labanalysisksm.models.entities.PatientStud;
import ru.labanalysisksm.services.PatientsStudDTOTestServiceImpl;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/patients/stud")
public class PatientStudController {
    private final PatientsStudDTOTestServiceImpl patientsStudDTOTestServiceImpl;

    public PatientStudController(PatientsStudDTOTestServiceImpl patientsStudDTOTestServiceImpl) {
        this.patientsStudDTOTestServiceImpl = patientsStudDTOTestServiceImpl;

    }

    @GetMapping()
    public String findAllPatients(Model model) {
        model.addAttribute("patientsStud", patientsStudDTOTestServiceImpl.findAllPatients());
        return "/patients/stud/index";
    }


    @GetMapping("/{id}")
    public String findOnePatient(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("patientStud", patientsStudDTOTestServiceImpl.findOnePatients(id));
        return "patient/stud/show";
    }

    @GetMapping
    public String showNewPatientStud(@ModelAttribute("patientStud") PatientStudTestDTO patientStudTestDTO) {
        return "patients/stud/new";
    }

    @PostMapping("/add")
    public String createPatient(@ModelAttribute("patientStud") PatientStudTestDTO patientStudTestDTO,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patients/stud/new";
        }
        patientsStudDTOTestServiceImpl.summarize(patientStudTestDTO);
        patientsStudDTOTestServiceImpl.save(patientStudTestDTO);
        return "redirect:/patient/stud";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("patientStud", patientsStudDTOTestServiceImpl.findOnePatients(id));
        return "patient/stud/edit";
    }

    @PatchMapping("/{id}")
    public String updatePatient(@ModelAttribute("patientStud") @Valid PatientStudTestDTO patientStudTestDTO,
                                @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/stud/edit";
        }
        patientsStudDTOTestServiceImpl.update(id, patientStudTestDTO);
        return "redirect:/patient/stud";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        patientsStudDTOTestServiceImpl.delete(id);
        return "redirect:/patient/stud";
    }

}


 */