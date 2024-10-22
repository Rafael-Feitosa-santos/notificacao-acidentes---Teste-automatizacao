package br.com.fiap.Notificacao.de.acidentes.service;

import br.com.fiap.Notificacao.de.acidentes.dto.OcorrenciaCadastroDto;
import br.com.fiap.Notificacao.de.acidentes.dto.OcorrenciaExibicaoDto;
import br.com.fiap.Notificacao.de.acidentes.model.Ocorrencia;
import br.com.fiap.Notificacao.de.acidentes.model.Status;
import br.com.fiap.Notificacao.de.acidentes.repository.OcorrenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaExibicaoDto gravar(OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        Ocorrencia ocorrencia = new Ocorrencia();
        BeanUtils.copyProperties(ocorrenciaCadastroDto, ocorrencia);
        ocorrencia.setStatus(Status.EM_ANDAMENTO);
        return new OcorrenciaExibicaoDto(ocorrenciaRepository.save(ocorrencia));
    }

    public List<OcorrenciaExibicaoDto> listaOcorrencia() {
        List<Ocorrencia> ocorrencia = ocorrenciaRepository.findAll();
        return ocorrencia
                .stream()
                .map(OcorrenciaExibicaoDto::new)
                .toList();
    }


//    public Ocorrencia atualizar(Ocorrencia ocorrencia) {
//        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(ocorrencia.getOcorrenciaId());
//        if (ocorrenciaOptional.isPresent()) {
//            return ocorrenciaRepository.save(ocorrencia);
//        } else {
//            throw new RuntimeException("Atualização não efetuada!");
//        }
//    }

    public Ocorrencia atualizar(Ocorrencia novaOcorrencia) {
        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(novaOcorrencia.getOcorrenciaId());
        if (ocorrenciaOptional.isPresent()) {
            Ocorrencia ocorrenciaExistente = ocorrenciaOptional.get();


            ocorrenciaExistente.setGravidade(novaOcorrencia.getGravidade());
            ocorrenciaExistente.setEndereco(novaOcorrencia.getEndereco());
            ocorrenciaExistente.setVitima(novaOcorrencia.getVitima());
            ocorrenciaExistente.setStatus(Status.EM_ANDAMENTO);

            return ocorrenciaRepository.save(ocorrenciaExistente);
        } else {
            throw new RuntimeException("Atualização não efetuada!");
        }
    }


    public void excluir(Long ocorrenciaId) {

        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(ocorrenciaId);

        if (ocorrenciaOptional.isPresent()) {
            ocorrenciaRepository.delete(ocorrenciaOptional.get());
        } else {
            throw new RuntimeException("Ocorrencia não encontrada!");
        }
    }

}
