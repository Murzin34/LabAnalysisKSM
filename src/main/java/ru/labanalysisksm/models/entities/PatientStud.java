package ru.labanalysisksm.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PatientStud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(max = 100, message = "Максимальная длина имени: 100 символов")
    @Column(name = "patient_Name")
    private String patientName;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(name = "local_Date", nullable = false)
    private LocalDate localDate;

    @Column(name = "cytology_TOR")
    private boolean cytologyTOR; // Цитология
    @Column(name = "hiv_TOR")
    private boolean hivTOR; // ВИЧ
    @Column(name = "syphilis_TOR")
    private boolean syphilisTOR; // Сифилис методом ИФА
    @Column(name = "coroutine_TOR")
    private boolean coroutineTOR; // Кал на кишеч группу
    @Column(name = "helminth_TOR")
    private boolean helminthTOR; // Гельминтологическое исследование фекалий на я\г
    @Column(name = "hepatitis_B_TOR")
    private boolean hepatitisBTOR; // Исследование крови на гепатит В
    @Column(name = "hepatitis_C_TOR")
    private boolean hepatitisCTOR; // Исследование крови на гепатит С
    @Column(name = "vidal_TOR")
    private boolean vidalTOR; // Серологическое исследование на брюшной тиф- Реакция Видаля с брюшнотифозными, паратифозными диагностикумами
    @Column(name = "sum")
    private Integer sum;

    public PatientStud(String patientName, LocalDate localDate, boolean cytologyTOR, boolean hivTOR, boolean syphilisTOR,
                       boolean coroutineTOR, boolean helminthTOR, boolean hepatitisBTOR, boolean hepatitisCTOR,
                       boolean vidalTOR, Integer sum) {
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
        this.sum = sum;
    }
}
