package com.estudo.cipa.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudo.cipa.votacao.model.Candidato;

import java.util.Optional;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByNumero(Integer numero);
    // Consultas específicas de Candidato
}
