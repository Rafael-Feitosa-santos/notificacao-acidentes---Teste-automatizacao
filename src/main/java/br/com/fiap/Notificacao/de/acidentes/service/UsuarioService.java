package br.com.fiap.Notificacao.de.acidentes.service;

import br.com.fiap.Notificacao.de.acidentes.dto.UsuarioCadastroDto;
import br.com.fiap.Notificacao.de.acidentes.dto.UsuarioExibicaoDto;
import br.com.fiap.Notificacao.de.acidentes.model.Usuario;
import br.com.fiap.Notificacao.de.acidentes.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioDto) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = repository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    public List<UsuarioExibicaoDto> listar() {
        return repository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional =
                repository.findById(id);

        if (usuarioOptional.isPresent()) {
            repository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }
}
