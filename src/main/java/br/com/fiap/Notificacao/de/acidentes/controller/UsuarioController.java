package br.com.fiap.Notificacao.de.acidentes.controller;

import br.com.fiap.Notificacao.de.acidentes.dto.UsuarioCadastroDto;
import br.com.fiap.Notificacao.de.acidentes.dto.UsuarioExibicaoDto;
import br.com.fiap.Notificacao.de.acidentes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioCadastroDto usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> listar() {
        return usuarioService.listar();
    }

    @DeleteMapping("/usuario/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId) {
        usuarioService.excluir(usuarioId);
    }

}
