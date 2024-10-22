package br.com.fiap.Notificacao.de.acidentes.dto;

import br.com.fiap.Notificacao.de.acidentes.model.Usuario;
import br.com.fiap.Notificacao.de.acidentes.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email,
        UsuarioRole role

) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()

        );
    }
}
