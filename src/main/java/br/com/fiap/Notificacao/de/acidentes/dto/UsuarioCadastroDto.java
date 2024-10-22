package br.com.fiap.Notificacao.de.acidentes.dto;

import br.com.fiap.Notificacao.de.acidentes.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(

        Long id,

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usuário não é válido!")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 10,
                message = "A senha deve ter entre 6 e 10 caracteres")
        String senha,
        UsuarioRole role
) {
}
