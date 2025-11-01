package com.estudo.cipa.votacao.repository;

import com.estudo.cipa.votacao.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // <-- necessário

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByNumero(Integer numero);
}

