package br.com.fiap.Notificacao.de.acidentes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record LoginDto(

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "E-mail do usuário não é válido")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 10, message = "A senha deve ter entre 6 e 10 caracteres")
        String senha
) {
}
