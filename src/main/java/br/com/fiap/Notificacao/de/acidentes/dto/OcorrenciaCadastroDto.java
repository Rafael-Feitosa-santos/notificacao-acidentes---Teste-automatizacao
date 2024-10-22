package br.com.fiap.Notificacao.de.acidentes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OcorrenciaCadastroDto(

        Long ocorrenciaId,

        @NotBlank(message = "Gravidade do Acidente é obrigatório!")
        String gravidade,

        @NotBlank(message = "Endereço é obrigatório!")
        String endereco,

        @NotBlank(message = "É obrigatório informa se possui vítima!")
        String vitima


) {
}
