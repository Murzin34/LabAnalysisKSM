package ru.labanalysisksm.models.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientStudTestDTO {

    private Integer id;

    private String patientName;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate localDate;

    private boolean cytologyTOR; // Цитология

    private boolean hivTOR; // ВИЧ

    private boolean syphilisTOR; // Сифилис методом ИФА

    private boolean coroutineTOR; // Кал на кишеч группу

    private boolean helminthTOR; // Гельминтологическое исследование фекалий на я\г

    private boolean hepatitisBTOR; // Исследование крови на гепатит В

    private boolean hepatitisCTOR; // Исследование крови на гепатит С

    private boolean vidalTOR; // Серологическое исследование на брюшной тиф- Реакция Видаля с брюшнотифозными, паратифозными диагностикумами

    private Integer sum;

    public PatientStudTestDTO(String patientName, LocalDate localDate, boolean cytologyTOR, boolean hivTOR, boolean syphilisTOR, boolean coroutineTOR, boolean helminthTOR, boolean hepatitisBTOR, boolean hepatitisCTOR, boolean vidalTOR) {
        this.patientName = patientName;
        this.localDate = localDate;
        this.cytologyTOR = cytologyTOR;
        this.hivTOR = hivTOR;
        this.syphilisTOR = syphilisTOR;
        this.coroutineTOR = coroutineTOR;
        this.helminthTOR = helminthTOR;
        this.hepatitisBTOR = hepatitisBTOR;
        this.hepatitisCTOR = hepatitisCTOR;
        this.vidalTOR = vidalTOR;
    }
}
