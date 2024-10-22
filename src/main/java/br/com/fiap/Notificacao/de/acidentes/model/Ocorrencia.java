package br.com.fiap.Notificacao.de.acidentes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "TBL_OCORRENCIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Ocorrencia {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_TBL_OCORRENCIA"
    )
    @SequenceGenerator(
            name = "SQ_TBL_OCORRENCIA",
            sequenceName = "SQ_TBL_OCORRENCIA",
            allocationSize = 1
    )
    private Long ocorrenciaId;

    @Column(name = "DT_OCORRENCIA")
    private LocalDate dataOcorrencia;

    @Column(name = "HR_OCORRENCIA")
    private LocalTime horaOcorrencia;

    private String gravidade;

    @Column(name = "DS_ENDERECO")
    private String endereco;

    private String vitima;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    protected void onCreate(){
        horaOcorrencia = LocalTime.now();
        dataOcorrencia = LocalDate.now();
    }



}
