package br.com.fiap.Notificacao.de.acidentes.dto;

import br.com.fiap.Notificacao.de.acidentes.model.Ocorrencia;
import br.com.fiap.Notificacao.de.acidentes.model.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public record OcorrenciaExibicaoDto(

        Long ocorrenciaID,
        LocalDate dataOcorrencia,
        String horarioOcorrencia,
        String gravidade,
        String endereco,
        String vitima,
        Status status
) {

    public OcorrenciaExibicaoDto(Ocorrencia ocorrencia) {
        this(
                ocorrencia.getOcorrenciaId(),
                ocorrencia.getDataOcorrencia(),
                formataHorario(ocorrencia.getHoraOcorrencia()),
                ocorrencia.getGravidade(),
                ocorrencia.getEndereco(),
                ocorrencia.getVitima(),
                ocorrencia.getStatus()
        );
    }

    private static String formataHorario(LocalTime horaOcorrencia) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horaOcorrencia.format(formatter);
    }
}

