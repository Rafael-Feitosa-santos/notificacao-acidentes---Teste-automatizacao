package br.com.fiap.Notificacao.de.acidentes.controller;

import br.com.fiap.Notificacao.de.acidentes.dto.OcorrenciaCadastroDto;
import br.com.fiap.Notificacao.de.acidentes.dto.OcorrenciaExibicaoDto;
import br.com.fiap.Notificacao.de.acidentes.model.Ocorrencia;
import br.com.fiap.Notificacao.de.acidentes.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @PostMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaExibicaoDto salvar(@RequestBody @Valid OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        return service.gravar(ocorrenciaCadastroDto);
    }

    @GetMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.OK)
    public List<OcorrenciaExibicaoDto> listarOcorrencia() {
        return service.listaOcorrencia();
    }

    @PutMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.OK)
    public Ocorrencia atualizar(@RequestBody Ocorrencia ocorrencia) {
        return service.atualizar(ocorrencia);
    }

    @DeleteMapping("/ocorrencia/{ocorrenciaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long ocorrenciaId) {
        service.excluir(ocorrenciaId);
    }

}
