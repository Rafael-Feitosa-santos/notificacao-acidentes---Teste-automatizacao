package br.com.fiap.Notificacao.de.acidentes.repository;

import br.com.fiap.Notificacao.de.acidentes.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
